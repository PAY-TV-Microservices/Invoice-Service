package br.ada.invoiceService.utils;

import java.math.BigDecimal;

public class InvoiceCalculator {
    public static BigDecimal calculateInvoiceValue(BigDecimal totalPackages, BigDecimal percDiscount) {
        BigDecimal discountMultiplier = percDiscount.divide(BigDecimal.valueOf(100));
        BigDecimal value = totalPackages.subtract(totalPackages.multiply(discountMultiplier));
        return value.max(BigDecimal.ZERO);
    }
}
