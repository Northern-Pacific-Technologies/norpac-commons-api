package com.norpactech.nc.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.norpactech.nc.dto.cognito.ChangePasswordRequest;
import com.norpactech.nc.dto.cognito.ConfirmSignUpRequest;
import com.norpactech.nc.dto.cognito.EnableMfaRequest;
import com.norpactech.nc.dto.cognito.ForgotPasswordRequest;
import com.norpactech.nc.dto.cognito.RefreshTokenRequest;
import com.norpactech.nc.dto.cognito.ResendCodeRequest;
import com.norpactech.nc.dto.cognito.SignInRequest;
import com.norpactech.nc.dto.cognito.SignOutRequest;
import com.norpactech.nc.dto.cognito.SignUpRequest;
import com.norpactech.nc.service.CognitoServiceEx;

@RestController
@RequestMapping("/")
public class CognitoController {
	
  @Autowired 
  CognitoServiceEx cognitoService;

  @Autowired
  GsonConfig gsonConfig;

  @PostMapping("/sign-up")
  public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {

    ApiResponse response = cognitoService.signUp(request.getUsername(), request.getPassword());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  @PostMapping("/confirm-sign-up")
  public ResponseEntity<String> confirmSignUp(@RequestBody ConfirmSignUpRequest request) {

    ApiResponse response = cognitoService.confirmSignUp(request.getUsername(), request.getConfirmationCode());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
  
  @PostMapping("/enable-mfa")
  public ResponseEntity<String> enableMfa(@RequestBody EnableMfaRequest request) {

    ApiResponse response = cognitoService.enableMfa(request.getUsername());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
  
  @PostMapping("/sign-in")
  public ResponseEntity<String> signIn(@RequestBody SignInRequest request) {

    ApiResponse response = cognitoService.signIn(request.getUsername(), request.getPassword());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  @SuppressWarnings("unchecked")
  @PostMapping("/access-token")
  public ResponseEntity<String> accessToken(String username, String password) {

    ApiResponse response = cognitoService.signIn(username, password);
    
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
  
  @PostMapping("/forgot-password")
  public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {

    ApiResponse response = cognitoService.forgotPassword(request.getUsername());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }  
  
  @PostMapping("/change-password")
  public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {

    ApiResponse response = cognitoService.changePassword(
        request.getUsername(), request.getConfirmationCode(), request.getPassword());
    
    if (response.getMeta() instanceof ApiErrorMeta) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gsonConfig.gson().toJson(response));
    }
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }  
  
  @PostMapping("/resend-code")
  public ResponseEntity<String> resendCode(@RequestBody ResendCodeRequest request) {

    ApiResponse response = cognitoService.resendCode(request.getUsername());
    
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