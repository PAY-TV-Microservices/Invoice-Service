package br.ada.invoiceService.payload;

import java.time.LocalDate;

import java.util.List;

public class Subscription2InvoiceRequest {
    private String userId;
    private LocalDate issueDate;

    private List<Invoice2PackageRequest> packageList;
}
