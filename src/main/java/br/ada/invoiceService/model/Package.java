package br.ada.invoiceService.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
  private String packageId;
  private BigDecimal packageValue;
  private BigDecimal dealValue;
}
