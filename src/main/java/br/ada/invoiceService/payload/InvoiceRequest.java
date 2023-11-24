package br.ada.invoiceService.payload;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class InvoiceRequest {
    private String userId;
    private LocalDate issueDate;
    private PackageRequest packagesIds;
    // recebe da assinatura
}
