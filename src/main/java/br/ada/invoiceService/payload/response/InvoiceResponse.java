package br.ada.invoiceService.payload.response;

import jakarta.persistence.GeneratedValue;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceResponse {
    private String invoiceId;
    private String userId;
    private LocalDate dueDate;
    private BigDecimal totalCost;
    // devolve pra pagamento
}
