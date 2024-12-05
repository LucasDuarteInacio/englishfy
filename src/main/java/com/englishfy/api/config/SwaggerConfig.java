package com.englishfy.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import java.time.Year;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

  public static final String API_DESCRIPTION = "API for Project Englishfy";
  public static final String API_LICENSE = "Project Englishfy © " + Year.now().getValue();
  public static final String API_TITLE = "Englishfy API";
  public static final String API_VERSION = "1.0.0";

  @Bean
  public OpenAPI configApi() {
    return new OpenAPI().info(openApiInfo());
  }

  private Info openApiInfo() {
    return new Info()
        .title(API_TITLE)
        .description(API_DESCRIPTION)
        .version(API_VERSION)
        .license(new License().name(API_LICENSE));
  }
}
