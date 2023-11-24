package br.ada.invoiceService.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageResponse {
  private String packageId;
  private BigDecimal packageValue;
  private BigDecimal dealValue;
  // recebe do pacote
}
