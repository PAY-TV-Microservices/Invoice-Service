package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.repository.InvoiceRepository;
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
    packageValuesService.execute(invoice);
    return new PackageResponse();
  }
}
