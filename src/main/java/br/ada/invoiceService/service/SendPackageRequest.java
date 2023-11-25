package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.model.Package;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.repository.InvoiceRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class SendPackageRequest {

  @Autowired
  private final InvoiceRepository invoiceRepository;
  @Autowired
  private final GetPackageValuesService packageValuesService;
  @Autowired
  private final WebClient webClient;

  public PackageResponse sendRequest(PackageRequest packageRequest) {
    PackageResponse packageResponse = webClient.post()
      .uri("/packages")
      .bodyValue(packageRequest)
      .retrieve()
      .bodyToMono(PackageResponse.class)
      .block();

    for (String packageId : packageRequest.getPackageIds()) {
      Invoice response = invoiceRepository.findByPackageId(packageId);

      BigDecimal packageIdResponse = packageValuesService.getPackagesValues();

      Package packageValues = new Package();
      packageValues.setPackageId(packageId);
        if (response != null) {
          packageValues.setPackageValue(packageIdResponse);
          packageValues.setDealValue(response.getDealValue());
        }

      packageResponse.getListPackages().add(packageValues.toString());
    }
    return packageResponse;
  }
}
