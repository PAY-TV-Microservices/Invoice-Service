package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Package;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WebClientService {
  private final RestTemplate restTemplate;

  public WebClientService() {
    this.restTemplate = new RestTemplate();
  }

  public Package getPackageValues() {
  String URL = UriComponentsBuilder.fromHttpUrl("http://localhost:8081")
    .path("/package")
    .toUriString();

  try {
    ResponseEntity<Package> response = restTemplate.getForEntity(URL, Package.class);

    if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
      return response.getBody();
    }
  } catch (Exception e) {
    throw new RuntimeException("Erro ao buscar valores do pacote");
  }
    return null;
  }
}
