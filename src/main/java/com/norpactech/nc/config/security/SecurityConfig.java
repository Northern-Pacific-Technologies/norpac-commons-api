package com.norpactech.nc.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Value("${cognito.region}")
  private String cognitoRegion;

  @Value("${cognito.user-pool-id}")
  private String userPoolId;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(authz -> authz
        // public endpoints
        .requestMatchers(
            "/health",
            "/auth-test",
            "/m2m-sign-in",
            "/access-token",
            "/refresh-token",
            "/sign-out"
        ).permitAll()

        // tenant bootstrap or other restricted endpoints
        .requestMatchers("/about", "/tenant/bootstrap")
          .hasAnyAuthority(
              "SCOPE_norpac-commons-api/super",
              "SCOPE_norpac-commons-api/admin"
          )
        // v1, v2... APIs
        .requestMatchers("/v*/**")
          .hasAnyAuthority(
              "SCOPE_norpac-commons-api/admin",
              "SCOPE_norpac-commons-api/read",
              "SCOPE_norpac-commons-api/write"
          )
        .anyRequest().authenticated()
      )
      .oauth2ResourceServer(oauth2 -> oauth2
        .jwt(jwt -> jwt
          .decoder(jwtDecoder())
          .jwtAuthenticationConverter(jwtAuthenticationConverter())
        )
      )
      .csrf(csrf -> csrf.disable())
      .cors(cors -> cors.configurationSource(corsConfigurationSource()));

    return http.build();
  }

  @Bean
  JwtAuthenticationConverter jwtAuthenticationConverter() {
    // Convert "cognito:groups" for user tokens
    JwtGrantedAuthoritiesConverter groupsConverter = new JwtGrantedAuthoritiesConverter();
    groupsConverter.setAuthorityPrefix("");
    groupsConverter.setAuthoritiesClaimName("cognito:groups");

    // Convert "scope" for client credentials tokens
    JwtGrantedAuthoritiesConverter scopeConverter = new JwtGrantedAuthoritiesConverter();
    scopeConverter.setAuthorityPrefix("SCOPE_");
    scopeConverter.setAuthoritiesClaimName("scope");

    // Compose both
    JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
    converter.setJwtGrantedAuthoritiesConverter(jwt -> {
      if (jwt.hasClaim("cognito:groups")) {
        return groupsConverter.convert(jwt);
      } else {
        return scopeConverter.convert(jwt);
      }
    });

    return converter;
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of(
      "http://localhost:4200",
      "https://dev.unitedbins.com",
      "https://www.unitedbins.com"
    ));
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  JwtDecoder jwtDecoder() {
    String jwkSetUri = String.format(
      "https://cognito-idp.%s.amazonaws.com/%s/.well-known/jwks.json",
      cognitoRegion,
      userPoolId
    );
    return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
  }
}
