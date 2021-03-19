package br.com.news.consumer.service;

import br.com.news.consumer.dto.Message;

public interface ConsumerService<T>{

    void action(Message message);
}
