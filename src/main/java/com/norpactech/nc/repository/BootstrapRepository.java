package com.norpactech.nc.repository;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nimbusds.jose.shaded.gson.Gson;
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.api.utils.ParseUtils;
import com.norpactech.nc.api.utils.PgsqlExecResponse;
import com.norpactech.nc.utils.TextUtils;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BootstrapRepository {

  protected final JdbcTemplate jdbcTemplate;

  public BootstrapRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  /**
   * Execute an insert operation without setting tenant context.
   * This method is used for bootstrap operations like initial tenant creation.
   * WARNING: This bypasses all tenant isolation - use with extreme caution!
   */
  @Transactional
  public ApiResponse insert(Map<String, Object> request) throws Exception {

    String sql = (String) request.get("sql");
    request.remove("sql");

    List<Object> params = new ArrayList<>();
    for (Object val : request.values()) {
        params.add(val);
    }
    
    try {
      return new ApiResponse((PgsqlExecResponse) jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new PgsqlExecResponse(rs), params.toArray()));
    }
    catch (Exception e) {
      log.error("Exception on bootstrap insert request {} - {}", new Gson().toJson(request), ParseUtils.stackTrace(e));
      return new ApiResponse((Exception) e);
    }
  }
  
  @Transactional
  public ApiResponse findOne(Map<String, Object> request, Class<?> clazz) {

    String schema = jdbcTemplate.queryForObject("SELECT current_schema()", String.class);
    String tableName = schema + "." + TextUtils.toSnakeCase(clazz.getSimpleName());

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
  } 
}