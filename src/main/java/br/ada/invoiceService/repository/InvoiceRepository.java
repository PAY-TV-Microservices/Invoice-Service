package br.ada.invoiceService.repository;

import br.ada.invoiceService.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

@Query(value = "SELECT * FROM invoices WHERE package_id = ?1", nativeQuery = true)
  Invoice findByPackageId(String packageId);
}
