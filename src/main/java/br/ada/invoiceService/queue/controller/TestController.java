package br.ada.invoiceService.queue.controller;


import br.ada.invoiceService.queue.QueueProducerPayment;
import br.ada.invoiceService.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/test")
public class TestController {

    private InvoiceService invoiceService;


    public String testingProducer(){
        invoiceService.issueInvoice2Payment("invoice1", "user1", LocalDate.of(2023,11,23), BigDecimal.valueOf(200));
        return "ok. done";
    }


}
