package br.ada.invoiceService.payload.response;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PackageResponse {
  ArrayList<Package> listPackages;
// recebe do pacote
}