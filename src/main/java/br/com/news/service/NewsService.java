package br.com.news.service;

import br.com.news.domain.News;
import br.com.news.exception.NotFoundException;
import br.com.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired NewsRepository newsRepository;

    public News save(News news){
        news.setCreatedDate(new Date());
        News newsSaved = newsRepository.save(news);
        return newsSaved;
    }

    public News findById(Long id){
        Optional<News> result = newsRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException("There no news with id " + id));
    }

    public List<News> listAll(){
        List<News> news = newsRepository.findAll();
        return news;
    }

    public News update(News news){
        News newsUpdated = newsRepository.save(news);
        return newsUpdated;
    }

    public void delete(Long id){
        News newsDeleted = findById(id);
       newsRepository.delete(newsDeleted);
    }

}
