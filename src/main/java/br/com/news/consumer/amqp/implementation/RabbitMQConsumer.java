package br.com.news.consumer.amqp.implementation;

import br.com.news.consumer.amqp.AmqpConsumer;
import br.com.news.consumer.dto.Message;
import br.com.news.consumer.service.ConsumerService;
import br.com.news.service.NewsService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

    @Autowired
    private ConsumerService consumerService;


    @Override
    @RabbitListener(queues = "rk.producer.news")
    public void consumer(Message message) {
        try {
            consumerService.action(message);

        }catch (Exception ex){
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
