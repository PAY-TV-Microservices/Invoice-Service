package br.ada.invoiceService.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageResponse {
  private String packageId;
  private BigDecimal packageValue;
  private BigDecimal dealValue;
  // recebe do pacote
}