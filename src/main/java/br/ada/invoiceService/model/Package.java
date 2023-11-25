package br.ada.invoiceService.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Package {
  private String packageId;
  private BigDecimal packageValue;
  private Integer dealValue;
}
