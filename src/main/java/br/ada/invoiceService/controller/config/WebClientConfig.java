package br.ada.invoiceService.controller.config;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
  @Value("${negocio.pagamento.url}")
  private String url;

  @Bean
  WebClient webClient() {
    return WebClient.builder()
      .baseUrl(url)
      .build();
  }

  @Bean
  PagamentoClient postPagamentoClient(WebClient webClient) {
    HttpServiceProxyFactory httpServiceProxyFactory =
      HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
        .build();
    return httpServiceProxyFactory.createClient(PagamentoClient.class);
  }
}
