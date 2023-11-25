package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Package;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPackageValuesService {

  private final WebClientService webClient;

  public BigDecimal getPackagesValues() {
    Package packageResponse = webClient.getPackageValues();

    if (packageResponse != null) {
      return packageResponse.getPackageValue();
    }
    return null;
  }
}
