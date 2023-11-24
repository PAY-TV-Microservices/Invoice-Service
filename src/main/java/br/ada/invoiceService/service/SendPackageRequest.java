package br.ada.invoiceService.service;

import br.ada.invoiceService.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendPackageRequest {

  private final InvoiceRepository invoiceRepository;
  private final GetPackageValuesService packageValuesService;

/*  public PackageResponse sendRequest(List<PackageRequest> packageRequest) {
    List<PackageResponse> packageResponseList = new ArrayList<>();
    for (PackageRequest packageRequest1 : packageRequest) {
      String packageId = packageValuesService.getPackageId(packageRequest1);
      if (Objects.nonNull(packageId)) {
        packageResponseList.add(new PackageResponse(packageId));
      }
    }
    return new PackageResponse(packageResponseList);
  }*/
}
