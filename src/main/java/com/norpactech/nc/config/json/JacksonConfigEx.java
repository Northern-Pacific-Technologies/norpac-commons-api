package com.norpactech.nc.config.json;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfigEx extends JacksonConfig {

  @Override
  @Bean
  public ObjectMapper objectMapper() {
    return super.objectMapper();
  }
}