package com.norpactech.nc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.norpactech.nc.api.utils.ApiErrorMeta;
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;
import com.norpactech.nc.service.ex.CognitoServiceEx;

@RestController
@RequestMapping("/")
@DependsOn("cognitoServiceEx")
public class CognitoController {
	
  @Autowired 
  CognitoServiceEx cognitoService;

  @Autowired
  GsonConfig gsonConfig;
  
  @PostMapping("/m2m-sign-in")
  public ResponseEntity<String> m2mSignIn(String secret, String scope) {

    ApiResponse response = cognitoService.m2mSignIn(secret, scope);
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
}