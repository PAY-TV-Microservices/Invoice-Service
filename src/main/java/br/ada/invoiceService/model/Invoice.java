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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoices")
public class Invoice {

  @Id
  private String id;

  @Column(name = "number")
  private String number; //número da fatura

  @Column(name = "user_id")
  private String userId; //id do usuário

  @Column(name = "issue_date")
  private LocalDate issueDate; //data de emissão

  @Column(name = "package_id")
  private String packageId; //id do pacote

  @Column(name = "package_value")
  private BigDecimal packageValue; //valor que recebemos do pacote

  @Column(name = "deal_value")
  private Integer dealValue; //desconto que recebemos do pacote em porcentagem

  @Column(name = "total_cost")
  private BigDecimal totalCost; //valor total da fatura

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private InvoiceStatus status; //status da fatura
}
