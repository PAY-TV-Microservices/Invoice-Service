package br.ada.invoiceService.controller.rest;

import br.ada.invoiceService.payload.InvoiceRequest;
import br.ada.invoiceService.payload.response.InvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {


  @PostMapping(value = "/")
  public InvoiceResponse realizarCompra(@RequestBody InvoiceRequest realizarCompraRequest) {

  }

}
