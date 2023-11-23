package br.ada.invoiceService.utils;

import java.math.BigDecimal;

public class InvoiceCalculator {
    public static BigDecimal calculateInvoiceValue(BigDecimal totalPackages, BigDecimal totalDiscount) {
        BigDecimal value = totalPackages.subtract(totalDiscount);
        return value.max(BigDecimal.ZERO);
    }
}
