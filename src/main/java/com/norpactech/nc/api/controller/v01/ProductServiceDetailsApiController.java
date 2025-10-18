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

import com.norpactech.nc.api.dto.ProductServiceDetailsActiveApiRequest;
import com.norpactech.nc.api.dto.ProductServiceDetailsPostApiRequest;
import com.norpactech.nc.api.dto.ProductServiceDetailsDeleteApiRequest;
import com.norpactech.nc.api.dto.ProductServiceDetailsPutApiRequest;

import com.norpactech.nc.api.model.ProductServiceDetails;

import com.norpactech.nc.api.repository.PgsqlRepository;

// Common Utility imports
import com.norpactech.nc.api.utils.ApiResponse;
import com.norpactech.nc.config.json.GsonConfig;

@RestController
@RequestMapping("/v01")
public class ProductServiceDetailsApiController {

  @Autowired
  PgsqlRepository paretoRepository;

  @Autowired
  GsonConfig gsonConfig;

  final String schema = "norpac-commons";

  @GetMapping("/product-service-details")
  public ResponseEntity<String> findOne(@RequestParam Map<String, String> params) throws Exception {

    ApiResponse response = paretoRepository.findOne(ProductServiceDetails.queryRequest(params), schema, ProductServiceDetails.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  } 
  
  @GetMapping("/product-service-details/find")
  public ResponseEntity<String> find(@RequestParam Map<String, String> params) throws Exception {

    Map<String, Object> request = ProductServiceDetails.queryRequest(params);
    ApiResponse response = paretoRepository.find(request, schema, ProductServiceDetails.class);
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
  
  @PostMapping("/product-service-details")
  public ResponseEntity<String> post(@RequestBody ProductServiceDetailsPostApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getInsertRequest());
    return ResponseEntity.status(HttpStatus.CREATED).body(gsonConfig.gson().toJson(response));
  }
  
  @PutMapping("/product-service-details")
  public ResponseEntity<String> put(@RequestBody ProductServiceDetailsPutApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getUpdateRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @PutMapping("/product-service-details/deact")
  public ResponseEntity<String> deact(@RequestBody ProductServiceDetailsActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getDeactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }

  @PutMapping("/product-service-details/react")
  public ResponseEntity<String> react(@RequestBody ProductServiceDetailsActiveApiRequest request) throws Exception {

    ApiResponse response = paretoRepository.execute(request.getReactRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
    
  @DeleteMapping("/product-service-details")
  public ResponseEntity<String> delete(@RequestBody ProductServiceDetailsDeleteApiRequest request) throws Exception {
    
    ApiResponse response = paretoRepository.execute(request.getDeleteRequest());
    return ResponseEntity.status(HttpStatus.OK).body(gsonConfig.gson().toJson(response));
  }
}