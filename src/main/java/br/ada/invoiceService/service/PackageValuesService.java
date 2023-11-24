package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PackageValuesService {

  private final WebClient webClient;

  public Mono<ResponseEntity<PackageResponse>> requestPackagesValues(Invoice invoice) {
    PackageRequest packageRequest = new PackageRequest();
    packageRequest.setPackageIds(List.of(invoice.getPackageId()));

    return webClient.post()
      .uri("/packages")
      .body(Mono.just(packageRequest), PackageRequest.class)
      .retrieve()
      .toEntity(PackageResponse.class);
  }

  /*public void execute(Invoice invoice) {
    PackageRequest packageRequest = new PackageRequest();
    packageRequest.setPackageIds(List.of(invoice.getPackageId()));
    Mono<PackageResponse> packageResponseMono = packageClient.getPackagesValues(packageRequest);

    packageResponseMono.subscribe(packageResponse -> {
      log.info("Solicitando infos de pacotes: {}", packageResponse);
      invoice.setPackageValue(packageResponse.getPackageValue());
      invoice.setDealValue(packageResponse.getDealValue().divideToIntegralValue(BigDecimal.valueOf(100)));
      invoice.setTotalCost(packageResponse.getPackageValue().subtract(packageResponse.getDealValue()));
      invoiceRepository.save(invoice);
    });
  }*/
}
