package br.ada.invoiceService.controller.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueRMQPayment {

    @Value("${payment.queue.issue-invoice.out}")
    private String queueName;

    @Bean
    public Queue queue(){
        return new Queue(queueName, true);
    }


}
