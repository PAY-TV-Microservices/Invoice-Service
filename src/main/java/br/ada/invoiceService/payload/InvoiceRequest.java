package br.ada.invoiceService.payload;

import java.time.LocalDate;

import java.util.List;

public class InvoiceRequest {
    private String skuId;
    private LocalDate issueDate;
    private List<PackageRequest> packageList;    
}
