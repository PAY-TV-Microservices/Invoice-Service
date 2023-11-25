package br.ada.invoiceService.service;

import br.ada.invoiceService.model.Invoice;
import br.ada.invoiceService.payload.InvoiceRequest;
import br.ada.invoiceService.payload.PackageRequest;
import br.ada.invoiceService.queue.QueueProducerPayment;
import br.ada.invoiceService.payload.response.InvoiceResponse;
import br.ada.invoiceService.repository.InvoiceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.ada.invoiceService.utils.InvoiceConvert.toEntityFromResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    SendPackageRequest sendPackageRequest;

    private final QueueProducerPayment queueProducerPayment;


    public void saveInfoFromSubscription(InvoiceRequest invoiceRequest){
        System.out.println("invoice request userId" + invoiceRequest.getUserId());
        sendPackageRequest.sendRequest(invoiceRequest.getPackagesIds());
        // -> disparar request pro pacote! (chamar o método que faz o request)

        // TODO
    }

    public void xxxxxx(){
        // TODO
        // envia lista de pacote,
        // recebe ids dos pacotes/valor pacotes/valor desconto
        // calculadora -> calcular valor total!


        // -> chamar issueInvoice2Payment

    }


    public void issueInvoice2Payment(String invoiceId, String userId, LocalDate dueDate, BigDecimal totalCost){
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setInvoiceId(invoiceId);
        invoiceResponse.setUserId(userId);
        invoiceResponse.setDueDate(dueDate);
        invoiceResponse.setTotalCost(totalCost);
        Invoice invoice = toEntityFromResponse(invoiceResponse);
        invoiceRepository.save(invoice);
        try {
            queueProducerPayment.send(invoiceResponse);
        } catch (JsonProcessingException e) {
            log.error("Não foi possível enviar a mensagem ao destinatário", e);
            throw new RuntimeException(e);
        }
    }
}
