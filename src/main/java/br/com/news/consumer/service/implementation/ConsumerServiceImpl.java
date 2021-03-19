package br.com.news.consumer.service.implementation;

import br.com.news.consumer.dto.Message;
import br.com.news.consumer.service.ConsumerService;
import br.com.news.domain.News;
import br.com.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService<Message>{

    @Autowired
    private NewsService newsService;

    @Override
    public void action(Message message){
        News news = newsService.transformToNews(message);
        newsService.save(news);
    }
}
