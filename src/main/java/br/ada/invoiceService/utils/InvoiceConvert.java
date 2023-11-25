package br.ada.invoiceService.utils;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.InvoiceRequest;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.InvoiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoiceConvert {

  public static Invoice toEntity(InvoiceRequest invoiceRequest) {
    Invoice invoice = new Invoice();
    invoice.setUserId(invoiceRequest.getUserId());
    invoice.setIssueDate(invoiceRequest.getIssueDate());

    return invoice;
  }

  public static InvoiceResponse toResponse(Invoice invoice) {
    InvoiceResponse invoiceResponse = new InvoiceResponse();
    invoiceResponse.setInvoiceId(invoice.getNumber());
    invoiceResponse.setUserId(invoice.getUserId());
    invoiceResponse.setDueDate(invoice.getIssueDate().plusDays(30));
    invoiceResponse.setTotalCost(invoice.getPackageValue());

    return invoiceResponse;
  }

  public static Invoice toEntityFromResponse(InvoiceResponse invoiceResponse) {
    Invoice invoice = new Invoice();
    invoice.setNumber(invoiceResponse.getInvoiceId());
    invoice.setUserId(invoiceResponse.getUserId());
    invoice.setIssueDate(invoiceResponse.getDueDate().minusDays(30));
    invoice.setTotalCost(invoiceResponse.getTotalCost());
    return invoice;
  }
}
