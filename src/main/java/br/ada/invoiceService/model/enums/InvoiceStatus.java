package br.ada.invoiceService.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InvoiceStatus {
  ISSUED("Emitida"),
  PAID("Paga"),
  PENDING("Pendente"),
  CANCELED("Cancelada");

  private final String description;
}
