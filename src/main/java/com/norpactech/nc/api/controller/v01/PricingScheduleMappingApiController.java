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

import com.norpactech.nc.api.dto.PricingScheduleMappingActiveApiRequest;
import com.norpactech.nc.api.dto.PricingScheduleMappingDeleteApiRequest;
import com.norpactech.nc.api.dto.PricingScheduleMappingPutApiRequest;
import com.norpactech.nc.api.dto.PricingScheduleMappingPostApiRequest;

import com.norpactech.nc.api.model.PricingScheduleMapping;

import com.norpactech.nc.api.repository.PgsqlRepository;

// Common Utility imports
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;

@RestController
@RequestMapping("/v01")
public class PricingScheduleMappingApiController {

  @Autowired
  PgsqlRepository paretoRepository;

  @Autowired
  GsonConfig gsonConfig;

  final String schema = "norpac-commons";

  @GetMapping("/pricing-schedule-mapping")
  public ResponseEntity<String> findOne(@RequestParam Map<String, String> params) throws Exception {

    ApiResponse response = paretoRepository.findOne(PricingScheduleMapping.queryRequest(params), schema, PricingScheduleMapping.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  } 
  
  @GetMapping("/pricing-schedule-mapping/find")
  public ResponseEntity<String> find(@RequestParam Map<String, String> params) throws Exception {

    Map<String, Object> request = PricingScheduleMapping.queryRequest(params);
    ApiResponse response = paretoRepository.find(request, schema, PricingScheduleMapping.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
  
  @PostMapping("/pricing-schedule-mapping")
  public ResponseEntity<String> post(@RequestBody PricingScheduleMappingPostApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getInsertRequest());
    return ResponseEntity.status(HttpStatus.CREATED).body(gsonConfig.gson().toJson(response));
  }
  
  @PutMapping("/pricing-schedule-mapping")
  public ResponseEntity<String> put(@RequestBody PricingScheduleMappingPutApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getUpdateRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @PutMapping("/pricing-schedule-mapping/deact")
  public ResponseEntity<String> deact(@RequestBody PricingScheduleMappingActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getDeactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  @PutMapping("/pricing-schedule-mapping/react")
  public ResponseEntity<String> react(@RequestBody PricingScheduleMappingActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getReactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @DeleteMapping("/pricing-schedule-mapping")
  public ResponseEntity<String> delete(@RequestBody PricingScheduleMappingDeleteApiRequest request) throws Exception {
    
    ApiResponse response = paretoRepository.execute(request.getDeleteRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
}