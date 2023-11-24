package br.ada.invoiceService.controller;

import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.PackageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageValueController {


  @PostMapping
  public PackageResponse getPackagesValues(@RequestBody PackageRequest packageRequest) {
    //TODO
    return null;
  }
}
