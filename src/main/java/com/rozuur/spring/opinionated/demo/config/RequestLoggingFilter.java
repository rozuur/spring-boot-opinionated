package com.rozuur.spring.opinionated.demo.config;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * Filter to log each request with payload. Default usage of CommonsRequestLoggingFilter logs duplicate requests at
 * beforeRequest and afterRequest
 */
public class RequestLoggingFilter extends CommonsRequestLoggingFilter {
    private final String healthEndpointPath;

    public RequestLoggingFilter(String healthEndpointPath) {
        this.healthEndpointPath = healthEndpointPath;
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(10000);
        super.setIncludeHeaders(false);
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return logger.isInfoEnabled() && !request.getRequestURI().contains(healthEndpointPath);
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        // Don't log beforeRequest as similar message is logged in afterRequest
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        logger.info(message);
    }
}