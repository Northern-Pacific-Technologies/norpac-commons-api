package com.norpactech.nc.controller;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 * 
 * For details, see the LICENSE file in this project root.
 */
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.norpactech.nc.api.dto.TenantPostApiRequest;
import com.norpactech.nc.api.model.Tenant;
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;
import com.norpactech.nc.repository.BootstrapRepository;
import com.norpactech.nc.utils.DateUtils;
import com.norpactech.nc.vo.AboutVO;

@RestController
@RequestMapping("/")
public class CommonsController {
	
  private static ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());    
    
  @Value("${spring.application.name}")
  private String name;
    
  @Value("${united-bins.version}")
  private String version;

  @Value("${spring.profiles.active}")
  private String profiles;

  @Autowired
  GsonConfig gsonConfig;
  
  @Autowired
  private DataSource dataSource;

  @Autowired
  private BootstrapRepository bootstrapRepository;
  
  @GetMapping("/health")
  public Map<String, String> health() {
    Map<String, String> status = new HashMap<>();
    status.put("status", "OK");
    return status;
  }
  
  @GetMapping("/about")
  public AboutVO about() throws Exception { 
    
    String started = DateUtils.formatDayMinutesSeconds(zonedDateTime);
    String authorities = "unavailable";

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      authorities = authentication.getAuthorities().toString();
    }    
    String databaseSchema = dataSource.getConnection().getCatalog();

    AboutVO aboutVO = new AboutVO();
    aboutVO.setApplication(name);
    aboutVO.setVersion(version);
    aboutVO.setProfiles(profiles);
    aboutVO.setStarted(started);
    aboutVO.setAuthorities(authorities);
    aboutVO.setDatabaseSchema(databaseSchema);
    return aboutVO;
  }
      
  @GetMapping("/auth-test")
  public Map<String, Object> debugAuthentication() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    Map<String, Object> result = new HashMap<>();
    result.put("authenticationExists", auth != null);
    result.put("isAuthenticated", auth != null ? auth.isAuthenticated() : false);
    result.put("authenticationClass", auth != null ? auth.getClass().getName() : "null");
    result.put("principalClass", auth != null && auth.getPrincipal() != null ? 
        auth.getPrincipal().getClass().getName() : "null");
    result.put("authorities", auth != null ? auth.getAuthorities() : "null");
    result.put("name", auth != null ? auth.getName() : "null");

    return result;
  } 
    
  @PostMapping("/tenant/bootstrap")
  public ResponseEntity<String> postTenant(@RequestBody TenantPostApiRequest request) throws Exception {
    
    ApiResponse response = bootstrapRepository.insert(request.getInsertRequest());
    return ResponseEntity.status(HttpStatus.CREATED).body(gsonConfig.gson().toJson(response));
  }  
  
  @GetMapping("/tenant/bootstrap")
  public ResponseEntity<String> findTenant(@RequestParam Map<String, String> params) throws Exception {

    ApiResponse response = bootstrapRepository.findOne(Tenant.queryRequest(params), Tenant.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }    
/*  
 * TODO: Enable when User model is available in Commons module
  @GetMapping("/user/bootstrap")
  public ResponseEntity<String> findUser(@RequestParam Map<String, String> params) throws Exception {

    ApiResponse response = bootstrapRepository.findOne(Tenant.queryRequest(params), User.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }  
  
  @GetMapping("/tenant-user/bootstrap")
  public ResponseEntity<String> findTenantUser(@RequestParam String email) throws Exception {

    List<TenantUserVO> response = bootstrapRepository.findTenantUser(email);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
     */
}