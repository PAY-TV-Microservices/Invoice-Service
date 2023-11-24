package br.ada.invoiceService.queue;

import br.ada.invoiceService.payload.Invoice2PaymentRequest;
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

    public void send(Invoice2PaymentRequest invoice2PaymentRequest) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(invoice2PaymentRequest);
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }







}
