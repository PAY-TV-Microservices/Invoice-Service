package br.ada.invoiceService.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageRequest {
    private List<String> packageIds;
    //envia para pacote
}
