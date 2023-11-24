package br.ada.invoiceService.service;

import br.ada.invoiceService.payload.Subscription2InvoiceRequest;
import br.ada.invoiceService.queue.QueueProducerPayment;
import br.ada.invoiceService.payload.Invoice2PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {

    private final QueueProducerPayment queueProducerPayment;

    public void saveInfoFromSubscription(Subscription2InvoiceRequest subscription2InvoiceRequest){
        // TODO

    }
    public void requestPriceInfoFromPackages(){
        // TODO
        // envia lista de pacotes (Invoice2PackageRequest.java),
        // recebe ids dos pacotes/valor pacotes/valor desconto (Package2InvoiceResponse.java)

    }

    public void consolidateInvoiceData(){
        // TODO
        // Unir infos obtidas da assinatura e dos pacotes e chamar InvoiceCalculator.java pra calcular o total
    }

    public void issueInvoice2Payment(String invoiceId, String userId, LocalDate dueDate, BigDecimal totalCost){
        Invoice2PaymentRequest invoice2PaymentRequest = new Invoice2PaymentRequest();
        invoice2PaymentRequest.setInvoiceId(invoiceId);
        invoice2PaymentRequest.setUserId(userId);
        invoice2PaymentRequest.setDueDate(dueDate);
        invoice2PaymentRequest.setTotalCost(totalCost);
        try {
            queueProducerPayment.send(invoice2PaymentRequest);
        } catch (JsonProcessingException e) {
            log.error("Não foi possível enviar a mensagem ao destinatário", e);
            throw new RuntimeException(e);
        }

    }



}
