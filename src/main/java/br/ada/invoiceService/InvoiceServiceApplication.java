package br.ada.invoiceService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class InvoiceServiceApplication {

//	private final CriarPagamentoProducer criarPagamentoProducer;

	public static void main(String[] args) {
		SpringApplication.run(InvoiceServiceApplication.class, args);

//		IssueInvoiceRequest issueInvoiceRequest = new IssueInvoiceRequest();
//		issueInvoiceRequest.setId("id = 14568");
//
//		CriarPagamentoProducer criarPagamentoProducer = new CriarPagamentoProducer()
	}

}
