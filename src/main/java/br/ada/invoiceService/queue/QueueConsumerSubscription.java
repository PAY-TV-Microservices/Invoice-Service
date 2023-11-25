package br.ada.invoiceService.queue;

import br.ada.invoiceService.payload.InvoiceRequest;
import br.ada.invoiceService.service.InvoiceService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueueConsumerSubscription {
    private final ObjectMapper objectMapper;
    private final InvoiceService invoiceService;

    @RabbitListener(queues = {"${subscription.queue.receive-info.in}"})
    public void receive(Message message, Channel channel) throws IOException {
        log.info("[QueueConsumerSubscription] Mensagem recebida {}", message.getBody());
        try {
            InvoiceRequest invoiceRequest = objectMapper.readValue(message.getBody(), InvoiceRequest.class);
            invoiceService.saveInfoFromSubscription(invoiceRequest);
            log.info("[QueueConsumerSubscription] Mensagem consumida {}", message);
        } catch (Exception e) {
            log.info("[QueueConsumerSubscription] Message with error.");
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}