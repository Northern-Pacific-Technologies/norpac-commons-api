package com.norpactech.nc.config.json;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.norpactech.nc.config.json.GsonConfig;

@Configuration
public class GsonConfigEx extends GsonConfig {

  @Override
  @Bean
  public Gson gson() {
    return super.gson();
  }
}