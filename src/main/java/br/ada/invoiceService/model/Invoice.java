package br.ada.invoiceService.model;

import br.ada.invoiceService.model.enums.InvoiceStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "invoices")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name = "number", nullable = false)
  private String number; //número da fatura

  @Column(name = "user_id", nullable = false)
  private String userId; //id do usuário

  @Column(name = "issue_date", nullable = false)
  private LocalDate issueDate; //data de emissão

  @Column(name = "total_cost", nullable = false)
  private BigDecimal totalCost; //valor total da fatura

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private InvoiceStatus status; //status da fatura
}
