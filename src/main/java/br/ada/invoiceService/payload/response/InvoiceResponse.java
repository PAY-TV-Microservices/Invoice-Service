package br.ada.invoiceService.payload.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceResponse {
    private String invoiceId;
    private String userId;
    private LocalDate dueDate;
    private BigDecimal totalCost;
}
