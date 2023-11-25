package br.ada.invoiceService.controller.config;

import br.ada.invoiceService.client.PackageClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

  @Bean
  public WebClient webClient() {
    return WebClient
      .builder()
        .baseUrl("http://localhost:8080/packages")
        .build();
  }

  @Bean
  PackageClient packageClient(WebClient webClient) {
    HttpServiceProxyFactory factory =
      HttpServiceProxyFactory.builder(WebClientAdapter
        .forClient(webClient)).build();
    return factory.createClient(PackageClient.class);
  }
}
