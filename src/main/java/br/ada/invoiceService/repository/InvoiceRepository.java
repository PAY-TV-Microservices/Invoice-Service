package br.ada.invoiceService.repository;

import br.ada.invoiceService.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
