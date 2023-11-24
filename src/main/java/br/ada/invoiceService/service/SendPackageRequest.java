package br.ada.invoiceService.service;

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

  public PackageResponse sendRequest(List<PackageRequest> packageRequest) {
   PackageResponse packageResponse = new PackageResponse();

   for (PackageRequest request : packageRequest) {
     Package response = invoiceRepository.findById(request.getPackageId()).orElse(null);
   }
}
