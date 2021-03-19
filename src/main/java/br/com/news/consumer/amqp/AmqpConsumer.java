package br.com.news.consumer.amqp;

public interface AmqpConsumer<T> {

    void consumer(T t);
}

