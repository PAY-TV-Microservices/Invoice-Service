package br.ada.invoiceService.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InvoiceRequest {
    private String userId;
    private LocalDate issueDate;
    private PackageRequest packagesIds;
    // recebe da assinatura
}
