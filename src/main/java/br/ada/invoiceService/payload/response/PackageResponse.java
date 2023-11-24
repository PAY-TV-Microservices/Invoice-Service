package br.ada.invoiceService.payload.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageResponse {
  private String packageIds;
  private BigDecimal packageValue;
  private BigDecimal dealValue;
  // recebe do pacote
}
