package br.ada.invoiceService.queue;


import br.ada.invoiceService.payload.Subscription2InvoiceRequest;
import br.ada.invoiceService.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueueConsumerSubscription {
    private final ObjectMapper objectMapper;
    private final InvoiceService invoiceService;

    @RabbitListener(queues = {"${subscription.queue.receive-info.in}"})
    public void receive(String message) throws JsonProcessingException {
        log.info("[QueueConsumerSubscription] Mensagem recebida {}", message);
        Subscription2InvoiceRequest subscription2InvoiceRequest = objectMapper.readValue(message, Subscription2InvoiceRequest.class);
        invoiceService.saveInfoFromSubscription(subscription2InvoiceRequest);
        log.info("[QueueConsumerSubscription] Mensagem consumida {}", message);

    }

}