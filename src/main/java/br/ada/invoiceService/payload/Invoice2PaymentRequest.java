package br.ada.invoiceService.payload;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Invoice2PaymentRequest {
        private String invoiceId;
        private String userId;
        private LocalDate dueDate;
        private BigDecimal totalCost;
}
