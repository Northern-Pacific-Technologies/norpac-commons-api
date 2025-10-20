package com.norpactech.nc.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.norpactech.nc.api.utils.ApiErrorMeta;
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;
import com.norpactech.nc.dto.cognito.ClientCredentialRequest;
import com.norpactech.nc.dto.cognito.RefreshTokenRequest;
import com.norpactech.nc.dto.cognito.SignOutRequest;
import com.norpactech.nc.service.CognitoServiceEx;

@RestController
@RequestMapping("/")
@DependsOn("cognitoServiceEx")
public class CognitoController {
	
  @Autowired 
  CognitoServiceEx cognitoService;

  @Autowired
  GsonConfig gsonConfig;
  
  @PostMapping("/m2m-sign-in")
  public ResponseEntity<String> m2mSignIn(@RequestBody ClientCredentialRequest request) {

    ApiResponse response = cognitoService.m2mSignIn(request.getClientSecret(), request.getScope());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  /**
   * Spoof Postman client credential flow - return access and refresh tokens
   * @param username
   * @param password
   * @return
   */
  @SuppressWarnings("unchecked")
  @PostMapping("/access-token")
  public ResponseEntity<String> accessToken(String username, String password) {

    ApiResponse response = cognitoService.m2mSignIn(username, password);
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    String json = gsonConfig.gson().toJson(response.getData());
    Map<String, String> tokenMap = new Gson().fromJson(json, Map.class);
    String accessToken = tokenMap.get("accessToken");
    String refreshToken = tokenMap.get("refreshToken");
    
    Map<String, String> tokenResponse = new HashMap<>();
    tokenResponse.put("access_token", accessToken);
    tokenResponse.put("refresh_token", refreshToken);    
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(tokenResponse));  
  }
  
  @PostMapping("/refresh-token")
  public ResponseEntity<String> refreshToken(@RequestBody RefreshTokenRequest request) {

    ApiResponse response = cognitoService.refreshToken(request.getRefreshToken());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }  
  
  @PostMapping("/sign-out")
  public ResponseEntity<String> signIn(@RequestBody SignOutRequest request) {

    ApiResponse response = cognitoService.signOut(request.getAccessToken());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
}