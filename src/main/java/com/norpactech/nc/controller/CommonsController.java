package com.norpactech.nc.controller;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 * 
 * This software is proprietary and may not be used, copied, modified, or distributed 
 * without permission. It is provided "as is" without warranties of any kind. 
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.norpactech.nc.config.json.GsonConfig;
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
}