package br.ada.invoiceService.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PackageRequest {
    private List<String> packageIds;
    //envia para pacote
}
