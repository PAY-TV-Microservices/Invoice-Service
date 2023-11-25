package br.ada.invoiceService.controller;

import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import br.ada.invoiceService.service.SendPackageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageValueController {
  private final SendPackageRequest sendPackageRequest;

  @PostMapping
  public PackageResponse getPackagesValues(@RequestBody PackageRequest packageRequest) {
    return sendPackageRequest.sendRequest(packageRequest);
  }
}
