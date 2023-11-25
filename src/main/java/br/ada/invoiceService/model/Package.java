package br.ada.invoiceService.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Package {
  private String packageId;
  private BigDecimal packageValue;
  private Integer dealValue;
}
