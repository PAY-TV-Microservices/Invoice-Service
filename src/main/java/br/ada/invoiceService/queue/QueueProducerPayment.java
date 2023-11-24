package br.ada.invoiceService.queue;

import br.ada.invoiceService.payload.response.InvoiceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueProducerPayment {
    private RabbitTemplate rabbitTemplate;

    private final Queue queue;

    private final ObjectMapper objectMapper;

    public void send(InvoiceResponse invoiceResponse) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(invoiceResponse);
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
