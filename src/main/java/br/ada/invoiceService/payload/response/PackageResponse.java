package br.ada.invoiceService.payload.response;

import java.lang.reflect.Array;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PackageResponse {
  ArrayList<PackageResponse> listPackages;
// recebe do pacote
}