package br.ada.invoiceService.payload.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageResponse {
  private String packageId;
  private BigDecimal packageValue;
  private BigDecimal dealValue;
// recebe do pacote
}