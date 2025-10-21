package com.norpactech.nc.service.ex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.norpactech.nc.service.CognitoService;

import jakarta.annotation.PostConstruct;

@Service
public class CognitoServiceEx extends CognitoService {

  @Value("${cognito.region}")
  String region;

  @Value("${cognito.user-pool-id}")
  String userPoolId;

  @Value("${cognito.user-pool-client-id}")
  String userPoolClientId;

  @Value("${cognito.user-pool-client-secret}")
  String userPoolClientSecret;
 
  @Value("${cognito.user-pool-domain}")
  String userPoolDomain = null;
  
  @PostConstruct
  public void init() {
    super.init(region, userPoolId, userPoolClientId, userPoolClientSecret, userPoolDomain);
  }    
}