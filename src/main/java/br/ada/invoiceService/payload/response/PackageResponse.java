package br.ada.invoiceService.payload.response;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PackageResponse {
  ArrayList<String> listPackages;
// recebe do pacote
}