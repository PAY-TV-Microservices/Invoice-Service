package br.ada.invoiceService.service;

import br.ada.invoiceService.controller.rest.PackageClient;
import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.repository.InvoiceRepository;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PackageValuesService {

  private final PackageClient packageClient;
  private final InvoiceRepository invoiceRepository;

  public void execute(Invoice invoice) {
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
  }
}
