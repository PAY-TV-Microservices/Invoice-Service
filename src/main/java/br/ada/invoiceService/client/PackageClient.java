package br.ada.invoiceService.client;

import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface PackageClient {

  @PostExchange("/packages")
  PackageResponse getPackageValues(@RequestBody PackageRequest packageRequest);
}
