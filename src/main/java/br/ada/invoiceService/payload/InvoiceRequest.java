package br.ada.invoiceService.payload;

import java.time.LocalDate;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {
    private String userId;
    private LocalDate issueDate;
    private PackageRequest packagesIds;
    // recebe da assinatura
}
