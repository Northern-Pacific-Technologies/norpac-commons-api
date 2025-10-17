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
    .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        // public end points - no authentication required
        .requestMatchers(
            "/health",
            "/auth-test",
            "/sign-up",             
            "/confirm-sign-up", 
            "/sign-in", 
            "/access-token", 
            "/refresh-token", 
            "/forgot-password", 
            "/change-password", 
            "/resend-code", 
            "/sign-out", 
            "/enable-mfa").permitAll()

        .requestMatchers(
            "/about", 
            "/tenant/bootstrap")
          .hasAnyAuthority(
            "norpac-super", 
            "united-bins-admin", 
            "united-bins-csr-admin")
        .requestMatchers("/v*/**").hasAnyAuthority(
            "norpac-super", 
            "united-bins-admin", 
            "united-bins-csr-admin", 
            "united-bins-csr-mgr", 
            "united-bins-csr-user")
        .anyRequest().hasAuthority("norpac-super"))
    .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
        .jwt(jwt -> jwt.decoder(jwtDecoder())
            .jwtAuthenticationConverter(jwtAuthenticationConverter())))
    .csrf(csrf -> csrf.disable())
    .cors(cors -> cors.configurationSource(corsConfigurationSource()));
    return http.build();
  }

  @Bean
  JwtAuthenticationConverter jwtAuthenticationConverter() {
    JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
    authoritiesConverter.setAuthorityPrefix("");
    authoritiesConverter.setAuthoritiesClaimName("cognito:groups");

    JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
    jwtConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
    return jwtConverter;
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.addAllowedOrigin("http://localhost:4200");
      configuration.addAllowedOrigin("https://dev.unitedbins.com/");
      configuration.addAllowedOrigin("https://www.unitedbins.com/");
      configuration.addAllowedHeader("*");
      configuration.addAllowedMethod("*");
      configuration.setAllowCredentials(true);

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
  }

  @Bean
  JwtDecoder jwtDecoder() {
    String jwkSetUri = String.format("https://cognito-idp.%s.amazonaws.com/%s/.well-known/jwks.json", cognitoRegion, userPoolId);
    return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
  }
}