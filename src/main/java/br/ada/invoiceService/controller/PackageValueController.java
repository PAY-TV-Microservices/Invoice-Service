package br.ada.invoiceService.controller;

import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.service.GetPackageValuesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageValueController {
  private final GetPackageValuesService getPackageValuesService;

  @PostMapping
  public PackageResponse getPackagesValues(@RequestBody List<PackageRequest> packageRequest) {
    return getPackageValuesService.requestPackagesValues(packageRequest);
  }
}
