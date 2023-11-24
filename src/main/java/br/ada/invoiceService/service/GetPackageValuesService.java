package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Package;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPackageValuesService {

  private final WebClientService webClient;

  public String getPackageId(PackageRequest packageRequest) {
  Package packageResponse = webClient.getPackageValues();

  if (packageResponse != null) {
    return packageResponse.getPackageId();
  }
    return null;
  }
}
