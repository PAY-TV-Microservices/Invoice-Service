package br.ada.invoiceService.payload.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class InvoiceResponse {
        private String invoiceId;
        private String userId;
        private LocalDate dueDate;
        private BigDecimal totalCost;
        // devolve para pagamento
}
