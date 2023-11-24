package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.repository.InvoiceRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendPackageRequestService {

  private final InvoiceRepository invoiceRepository;
  private final PackageValuesService packageValuesService;

  public PackageResponse sendRequest(PackageRequest packageRequest) {
    Invoice invoice = new Invoice();
    for (String packageId : packageRequest.getPackageIds()) {
      invoice.setPackageId(packageId);
      invoiceRepository.save(invoice);
    }
    packageValuesService.requestPackagesValues(invoice)
      .subscribe(
        responseEntity -> {
          invoice.setPackageValue(Objects.requireNonNull(responseEntity.getBody()).getPackageValue());
          invoice.setDealValue(responseEntity.getBody().getDealValue());
          invoice.setTotalCost(responseEntity.getBody().getPackageValue().subtract(responseEntity.getBody().getDealValue()));
          invoiceRepository.save(invoice);
        }
      );
  }
}
