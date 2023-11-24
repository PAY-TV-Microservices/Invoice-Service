package br.ada.invoiceService.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@ConfigurationProperties(prefix = "microservices.package")
@Getter @Setter
public class WebClientConfig {
  private String packageUrl;

  @Bean
  public WebClient packageWebClient() {
    return WebClient.builder()
      .baseUrl(packageUrl)
      .defaultCookie("cookie-name", "cookie-value")
      .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
      .build();
  }
}