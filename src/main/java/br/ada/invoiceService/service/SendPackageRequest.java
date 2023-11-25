package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.model.Package;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.repository.InvoiceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendPackageRequest {

  private final InvoiceRepository invoiceRepository;
  private final GetPackageValuesService packageValuesService;

  public PackageResponse sendRequest(PackageRequest packageRequest) {
    PackageResponse packageResponse = new PackageResponse(new ArrayList<>());

    for (String packageId : packageRequest.getPackageIds()) {
      Invoice response = invoiceRepository.findById(packageId).orElse(null);
    Package packageValues = new Package();
    packageValues.setPackageId(packageRequest.getPackageIds().get(0));
    packageValues.setPackageValue(response.getPackageValue());
    packageValues.setDealValue(response.getDealValue());

    packageResponse.getPackages().add(packageValues);
    // arrumar isso
    return packageResponse;
    }

  }
}
