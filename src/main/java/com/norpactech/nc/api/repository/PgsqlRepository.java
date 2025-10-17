package com.norpactech.nc.api.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.norpactech.nc.api.exception.ApiResponseException;
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.api.utils.ParseUtils;
import com.norpactech.nc.api.utils.PgsqlExecResponse;
import com.norpactech.nc.config.tenant.TenantContext;
import com.norpactech.nc.utils.Constant;
import com.norpactech.nc.utils.TextUtils;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PgsqlRepository {

  protected final JdbcTemplate jdbcTemplate;

  public PgsqlRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  } 
  
  @Transactional
  public ApiResponse execute(Map<String, Object> request) throws Exception {

    String sql = (String) request.get("sql");
    request.remove("sql");

    List<Object> params = new ArrayList<>();
    for (Map.Entry<String, Object> entry : request.entrySet()) {
      Object val = entry.getValue();

      if (val == null) {
        params.add(new SqlParameterValue(Types.NULL, null));
      } 
      else if (val instanceof Integer) {
        params.add(new SqlParameterValue(Types.INTEGER, val));
      } 
      else if (val instanceof Long) {
        params.add(new SqlParameterValue(Types.BIGINT, val));
      } 
      else if (val instanceof String) {
        params.add(new SqlParameterValue(Types.VARCHAR, val));
      } 
      else if (val instanceof Boolean) {
        params.add(new SqlParameterValue(Types.BOOLEAN, val));
      } 
      else if (val instanceof java.util.Date) {
        params.add(new SqlParameterValue(Types.TIMESTAMP, new Timestamp(((java.util.Date) val).getTime())));
      } 
      else if (val instanceof Double) {
        params.add(new SqlParameterValue(Types.NUMERIC, BigDecimal.valueOf((Double) val)));
      } 
      else if (val instanceof Float) {
        params.add(new SqlParameterValue(Types.NUMERIC, BigDecimal.valueOf((Float) val)));
      } 
      else if (val instanceof BigDecimal) {
        params.add(new SqlParameterValue(Types.NUMERIC, val));
      }
      else if (val instanceof UUID) {
        params.add(new SqlParameterValue(Types.OTHER, val));
      }
      else if (val instanceof java.time.LocalDateTime) {
        params.add(new SqlParameterValue(Types.TIMESTAMP, Timestamp.valueOf((LocalDateTime) val)));
      }
      else {
        params.add(val); // will fall back to normal binding
      }
    }    
    try {
      setTenantContext();
      return new ApiResponse((PgsqlExecResponse) jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new PgsqlExecResponse(rs), params.toArray()));
    }
    catch (Exception e) {
      log.error("Exception on request {} - {}", new Gson().toJson(request), ParseUtils.stackTrace(e));
      return new ApiResponse((Exception) e);
    }
    finally {
      clearTenantContext();
    }
  }
  /**
   * Caution! Snake Case address1 needs to be used as opposed to address_1 due to class
   *          conversions. 
   * @throws Exception 
   */
  @Transactional
  public ApiResponse findOne(Map<String, Object> request, String schema, Class<?> clazz) throws Exception {

    String tableName = schema.replace("-", "_") + "." + TextUtils.toSnakeCase(clazz.getSimpleName());

    String xsql = (String) request.get("sql");
    request.remove("sql");
    
    StringBuffer sql = new StringBuffer(xsql);
    List<Object> params = new ArrayList<>();
    if (!request.isEmpty()) {
      sql.append(" WHERE ");
      sql.append(String.join(" AND ", request.keySet().stream()
          .map(key -> {
            Object value = request.get(key);
            // Apply case-insensitive search for String values
            if (value instanceof String) {
              params.add(((String) value).toLowerCase());
              return "LOWER(" + tableName + "." + TextUtils.toSnakeCase(key) + ") = ?";
            } else {
              params.add(value);
              return tableName + "." + TextUtils.toSnakeCase(key) + " = ?";
            }
          })
          .toArray(String[]::new)));
    }

    try {
      setTenantContext();
      Object results = jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(clazz), params.toArray());

      ApiResponse retVal = new ApiResponse(results);
      long count = results == null ? 0l : 1l;
      retVal.getMeta().setCount(count);
      return retVal;      
    } 
    catch(EmptyResultDataAccessException e) {
      return new ApiResponse();
    }
    catch (Exception e) {
      log.error("Exception on request {} - {}", sql, ParseUtils.stackTrace(e));
      return new ApiResponse((Exception) e);
    }
    finally {
      clearTenantContext();
    }
  }  
  /**
   * Caution! Snake Case address1 needs to be used as opposed to address_1 due to class
   *          conversions. 
   * @throws Exception 
   */
  @Transactional
  public ApiResponse find(Map<String, Object> request, String schema, Class<?> clazz) throws Exception {
    
    String xsql = (String) request.get("sql");
    String limit = (String) request.get(Constant.LIMIT);
    String offset = (String) request.get(Constant.OFFSET);
    String sortColumn = (String) request.get(Constant.SORT_COLUMN);
    String sortDirection = (String) request.get(Constant.SORT_DIRECTION);
    
    if (StringUtils.isNotEmpty(limit)
    &&  StringUtils.isNotEmpty(offset)) {
      Long page = Long.valueOf(limit) * Long.valueOf(offset);
      offset = page.toString(); 
    }
    
    if (StringUtils.isEmpty(xsql)) {
      throw new ApiResponseException("SQL not present in find");
    }
    request.remove("sql");
    request.remove(Constant.LIMIT);
    request.remove(Constant.OFFSET);
    request.remove(Constant.SORT_COLUMN);
    request.remove(Constant.SORT_DIRECTION);
        
    StringBuffer sqlQuery = new StringBuffer(xsql);
    StringBuffer sqlCount = sqlCount(sqlQuery);
    request = request == null ? new HashMap<String, Object>() : request;

    String tableName = schema.replace("-", "_") + "." + TextUtils.toSnakeCase(clazz.getSimpleName());
    MapSqlParameterSource queryParams = this.groom(sqlQuery, request, tableName);
    MapSqlParameterSource countParams = this.groom(sqlCount, request, tableName);
    
    if (StringUtils.isNotEmpty(sortColumn)) {
      sqlQuery.append(" ORDER BY ").append(TextUtils.toSnakeCase(sortColumn)).append(" ");
    }
    if (StringUtils.isNotEmpty(sortDirection)) {
      sqlQuery.append(sortDirection).append(" ");
    }
    if (StringUtils.isNoneEmpty(limit)) {
      sqlQuery.append(" LIMIT ").append(limit);
    }
    if (StringUtils.isNotEmpty(offset)) {
      sqlQuery.append(" OFFSET ").append(offset);
    }
    NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

    try {
      setTenantContext();
      List<?> results = namedJdbcTemplate.query(sqlQuery.toString(), queryParams, new BeanPropertyRowMapper<>(clazz));
      ApiResponse retVal = new ApiResponse(results);
      
      Long count = namedJdbcTemplate.queryForObject(sqlCount.toString(), countParams, Long.class);
      if (count != null) {
        retVal.getMeta().setCount(count);
      }
      return retVal;
    } 
    catch (Exception e) {
      log.error("Exception on request {} - {}", sqlQuery, ParseUtils.stackTrace(e));
      return new ApiResponse((Exception) e);
    }
    finally {
      clearTenantContext();
    }
  }

  public void setTenantContext() throws Exception {
    String idTenant = TenantContext.getIdTenant();
    if (idTenant == null) {
      throw new IllegalStateException("Tenant context required in PgsqlRepository");
    }
    jdbcTemplate.execute("SELECT set_config('app.current_tenant', '" + idTenant + "', false)");
    String currentTenant = jdbcTemplate.queryForObject("SELECT current_setting('app.current_tenant', true)", String.class);
    // Debug: get current user and search_path
    String currentUser = jdbcTemplate.queryForObject("SELECT current_user", String.class);
    String searchPath = jdbcTemplate.queryForObject("SHOW search_path", String.class);
    log.debug("Tenant context set successfully: {} | current_user: {} | search_path: {} | current_tenant: {}", idTenant, currentUser, searchPath, currentTenant);
    if (!idTenant.equals(currentTenant)) {
      throw new IllegalStateException("Failed to set tenant context. Expected: " + idTenant + ", Actual: " + currentTenant);
    }
  }
  
  public void clearTenantContext() throws Exception {
    jdbcTemplate.execute("SELECT set_config('app.current_tenant', '', false)");
    log.debug("Tenant context cleared successfully");
  }
  
  private StringBuffer sqlCount(StringBuffer sqlQuery) {
    
    String regex = "(?i)SELECT\\s+.*?\\s+FROM";
    String retVal = sqlQuery.toString().replaceAll(regex, "SELECT COUNT(*) as count FROM");
    return new StringBuffer(retVal);    
  }
  
  private MapSqlParameterSource groom(StringBuffer sql, Map<String, Object> queryParams, String tableName) {

    Map<String, Object> filters = new HashMap<>();
    for (String key : queryParams.keySet()) {
      Object value = queryParams.get(key);
      
      if (value instanceof String) {
        String val = (String) queryParams.get(key);
        val = val.replace("*", "%");
        filters.put(key, val);
      }
      else {
        filters.put(key, value);
      }
    }
    
    if (!filters.isEmpty()) {
      sql.append(" WHERE ");
      sql.append(String.join(" AND ", filters.keySet().stream()
        .map(key -> {
          Object value = filters.get(key);
          if (value instanceof String && ((String) value).contains("%")) {
            return "LOWER(" + tableName + "." + TextUtils.toSnakeCase(key) + ") LIKE LOWER(:" + key + ")";
          } else if (value instanceof String) {
            return "LOWER(" + tableName + "." + TextUtils.toSnakeCase(key) + ") = LOWER(:" + key + ")";
          }
          else {
            return  tableName + "." + TextUtils.toSnakeCase(key) + " = :" + key;
          }
        })
        .toArray(String[]::new)));
    }
    MapSqlParameterSource parameters = new MapSqlParameterSource(filters);
    return parameters;
  }  
}