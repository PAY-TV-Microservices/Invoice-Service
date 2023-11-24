package br.ada.invoiceService.payload;

import java.time.LocalDate;

import java.util.List;
import lombok.Getter;

@Getter
public class InvoiceRequest {
    private String userId;
    private LocalDate issueDate;
    private List<PackageRequest> packagesIds;
    // recebe da assinatura
}
