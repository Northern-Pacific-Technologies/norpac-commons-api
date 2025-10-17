package com.norpactech.nc.config.tenant;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet Filter that enforces a tenant context for versioned API endpoints.
 *
 * Responsibilities:
 * - For requests that require tenant context (URIs that begin with a version segment
 *   like "/v1/" or "/v2024-10/"), read the tenant ID from the X-Tenant-ID request
 *   header and set it into {@link TenantContext} for the lifetime of the request thread.
 * - Skip tenant enforcement for authentication and other public endpoints.
 * - Always clear the thread-local context in a finally block to prevent leakage
 *   across requests when servlet threads are reused.
 *
 * Notes:
 * - This filter is stateless and safe to register as a Spring {@link Component}.
 * - Keep the allowlist in {@link #isAuthenticationEndpoint(String)} in sync with
 *   any other request-context checks to avoid divergence.
 */
@Component
public class TenantFilter implements Filter {
  
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest http = (HttpServletRequest) req;
    String requestUri = http.getRequestURI();

    // Determine if this request must carry a tenant context. If so, enforce that
    // the X-Tenant-ID header is present, set the context for downstream code, and
    // clear it afterwards. Otherwise, simply continue the chain.
    if (requiresTenantContext(requestUri)) {
      String idTenant = http.getHeader("X-Tenant-ID");

      if (StringUtils.isEmpty(idTenant)) {
        // Fail fast with a clear message to the caller indicating what's missing
        // and on which endpoint the check occurred.
        throw new ServletException("Missing X-Tenant-ID in Request Header for endpoint: " + requestUri);
      }

      try {
        // Bind tenant to the current thread for downstream services/repositories.
        TenantContext.setIdTenant(idTenant);
        chain.doFilter(req, res);
      } 
      finally {
        // Always clear to avoid ThreadLocal leaks across requests.
        TenantContext.clear();
      }
    } else {
      // No tenant context required - proceed without setting tenant
      chain.doFilter(req, res);
    }
  }
  /**
   * Returns true if the URI requires tenant context.
   *
   * Rules:
   * - Authentication and selected public endpoints never require tenant context.
   * - Any URI that starts with a version segment ("/v" followed by any non-slash
   *   chars and another "/"), e.g. "/v1/users" or "/v2024-10/items", does require it.
   *
   * @param uri raw request URI path (no scheme/host/query)
   * @return whether a tenant context must be present
   */
  private boolean requiresTenantContext(String uri) {
    if (uri == null) {
      return false;
    }

    // Authentication endpoints never require tenant context
    if (isAuthenticationEndpoint(uri)) {
      return false;
    }
    // Pattern: /v*/** requires tenant context
    // Regex explanation:
    // ^/v        -> must start with "/v"
    // [^/]*      -> zero or more non-slash characters (the version token)
    // /.*$       -> followed by a "/" and the rest of the path
    return uri.matches("^/v[^/]*/.*$");
  }
  /**
   * Allowlist of endpoints that should not require tenant context.
   *
   * Keep this list consistent with any similar checks (e.g., RequestContext) so
   * that behavior is uniform across request processing layers.
   *
   * @param uri request path
   * @return true if the endpoint is authentication/public and does not need tenant context
   */
  private boolean isAuthenticationEndpoint(String uri) {
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