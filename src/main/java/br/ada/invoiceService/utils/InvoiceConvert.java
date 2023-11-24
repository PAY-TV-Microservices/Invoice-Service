package br.ada.invoiceService.utils;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.InvoiceRequest;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.payload.response.InvoiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoiceConvert {

  public static Invoice toEntity(InvoiceRequest invoiceRequest, PackageRequest packageRequest) {
    Invoice invoice = new Invoice();
    invoice.setUserId(invoiceRequest.getUserId());
    invoice.setIssueDate(invoiceRequest.getIssueDate());
    invoice.setPackageId(packageRequest.getPackageId());

    return invoice;
  }

  public static InvoiceResponse toResponse(Invoice invoice) {
    InvoiceResponse invoiceResponse = new InvoiceResponse();
    invoiceResponse.setInvoiceId(invoice.getId());
    invoiceResponse.setUserId(invoice.getUserId());
    invoiceResponse.setDueDate(invoice.getIssueDate().plusDays(30));
    invoiceResponse.setTotalCost(invoice.getPackageValue());

    return invoiceResponse;
  }
}
