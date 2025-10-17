package com.norpactech.nc.config.tenant;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestContext {

  private RequestContext() {}

  public static HttpServletRequest getCurrentRequest() {
    try {
      ServletRequestAttributes attributes = 
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      return attributes != null ? attributes.getRequest() : null;
    } 
    catch (Exception e) {
      return null;
    }
  }

  public static String getCurrentRequestUri() {
    HttpServletRequest request = getCurrentRequest();
    return request != null ? request.getRequestURI() : null;
  }

  /**
   * Check if the current request requires tenant context based on URL pattern
   */
  public static boolean requiresTenantContext() {
    String uri = getCurrentRequestUri();
    if (uri == null) {
      return false; // No HTTP context (startup, background tasks, etc.)
    }

    // Authentication endpoints never require tenant context
    if (isAuthenticationEndpoint(uri)) {
      return false;
    }
    return uri.matches("^/v[^/]*/.*$"); 
  }

  /**
   * Check if the URI is an authentication endpoint that should not require tenant context
   */
  private static boolean isAuthenticationEndpoint(String uri) {
    return uri.equals("/sign-up") ||
           uri.equals("/confirm-sign-up") ||
           uri.equals("/sign-in") ||
           uri.equals("/access-token") ||
           uri.equals("/refresh-token") ||
           uri.equals("/forgot-password") ||
           uri.equals("/change-password") ||
           uri.equals("/resend-code") ||
           uri.equals("/sign-out") ||
           uri.equals("/enable-mfa") ||
           uri.equals("/health") ||
           uri.startsWith("/plugin/") ||
           uri.startsWith("/admin/");
  }
}