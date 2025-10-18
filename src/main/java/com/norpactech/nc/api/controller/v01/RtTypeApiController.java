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

import com.norpactech.nc.api.dto.RtTypeActiveApiRequest;
import com.norpactech.nc.api.dto.RtTypeDeleteApiRequest;
import com.norpactech.nc.api.dto.RtTypePutApiRequest;
import com.norpactech.nc.api.dto.RtTypePostApiRequest;

import com.norpactech.nc.api.model.RtType;

import com.norpactech.nc.api.repository.PgsqlRepository;

// Common Utility imports
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;

@RestController
@RequestMapping("/v01")
public class RtTypeApiController {

  @Autowired
  PgsqlRepository paretoRepository;

  @Autowired
  GsonConfig gsonConfig;

  final String schema = "norpac-commons";

  @GetMapping("/rt-type")
  public ResponseEntity<String> findOne(@RequestParam Map<String, String> params) throws Exception {

    ApiResponse response = paretoRepository.findOne(RtType.queryRequest(params), schema, RtType.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  } 
  
  @GetMapping("/rt-type/find")
  public ResponseEntity<String> find(@RequestParam Map<String, String> params) throws Exception {

    Map<String, Object> request = RtType.queryRequest(params);
    ApiResponse response = paretoRepository.find(request, schema, RtType.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
  
  @PostMapping("/rt-type")
  public ResponseEntity<String> post(@RequestBody RtTypePostApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getInsertRequest());
    return ResponseEntity.status(HttpStatus.CREATED).body(gsonConfig.gson().toJson(response));
  }
  
  @PutMapping("/rt-type")
  public ResponseEntity<String> put(@RequestBody RtTypePutApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getUpdateRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @PutMapping("/rt-type/deact")
  public ResponseEntity<String> deact(@RequestBody RtTypeActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getDeactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  @PutMapping("/rt-type/react")
  public ResponseEntity<String> react(@RequestBody RtTypeActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getReactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @DeleteMapping("/rt-type")
  public ResponseEntity<String> delete(@RequestBody RtTypeDeleteApiRequest request) throws Exception {
    
    ApiResponse response = paretoRepository.execute(request.getDeleteRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
}