package br.ada.invoiceService.payload.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceResponse {
        private String invoiceId;
        private String userId;
        private LocalDate dueDate;
        private BigDecimal totalCost;
        // devolve para pagamento
}
