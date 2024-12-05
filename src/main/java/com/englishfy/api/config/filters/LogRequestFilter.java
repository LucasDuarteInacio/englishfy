package com.englishfy.api.config.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(-1)
@Component
@RequiredArgsConstructor
@Slf4j
public class LogRequestFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    final long start = System.currentTimeMillis();

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String requestUri = httpRequest.getRequestURI();

    if (!requestUri.contains("/actuator")) {
      log.info("START - Request for {}", requestUri);

      chain.doFilter(request, response);

      long time = System.currentTimeMillis() - start;
      log.info("END - Request for {} | Duration: {}ms", requestUri, time);
    } else {
      chain.doFilter(request, response);
    }
  }
}
