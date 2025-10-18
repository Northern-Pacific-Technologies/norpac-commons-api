package com.norpactech.nc.api.controller.v01;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.norpactech.nc.api.dto.SubscriptionPlanPostApiRequest;
import com.norpactech.nc.api.dto.SubscriptionPlanActiveApiRequest;
import com.norpactech.nc.api.dto.SubscriptionPlanPutApiRequest;
import com.norpactech.nc.api.dto.SubscriptionPlanDeleteApiRequest;

import com.norpactech.nc.api.model.SubscriptionPlan;

import com.norpactech.nc.api.repository.PgsqlRepository;

// Common Utility imports
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;

@RestController
@RequestMapping("/v01")
public class SubscriptionPlanApiController {

  @Autowired
  PgsqlRepository paretoRepository;

  @Autowired
  GsonConfig gsonConfig;

  final String schema = "norpac-commons";

  @GetMapping("/subscription-plan")
  public ResponseEntity<String> findOne(@RequestParam Map<String, String> params) throws Exception {

    ApiResponse response = paretoRepository.findOne(SubscriptionPlan.queryRequest(params), schema, SubscriptionPlan.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  } 
  
  @GetMapping("/subscription-plan/find")
  public ResponseEntity<String> find(@RequestParam Map<String, String> params) throws Exception {

    Map<String, Object> request = SubscriptionPlan.queryRequest(params);
    ApiResponse response = paretoRepository.find(request, schema, SubscriptionPlan.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
  
  @PostMapping("/subscription-plan")
  public ResponseEntity<String> post(@RequestBody SubscriptionPlanPostApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getInsertRequest());
    return ResponseEntity.status(HttpStatus.CREATED).body(gsonConfig.gson().toJson(response));
  }
  
  @PutMapping("/subscription-plan")
  public ResponseEntity<String> put(@RequestBody SubscriptionPlanPutApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getUpdateRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @PutMapping("/subscription-plan/deact")
  public ResponseEntity<String> deact(@RequestBody SubscriptionPlanActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getDeactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  @PutMapping("/subscription-plan/react")
  public ResponseEntity<String> react(@RequestBody SubscriptionPlanActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getReactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @DeleteMapping("/subscription-plan")
  public ResponseEntity<String> delete(@RequestBody SubscriptionPlanDeleteApiRequest request) throws Exception {
    
    ApiResponse response = paretoRepository.execute(request.getDeleteRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
}