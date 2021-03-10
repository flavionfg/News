package br.com.news.repository;


import br.com.news.domain.News;
import br.com.news.service.NewsService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NewsRepositoryTests {

    @Autowired private NewsRepository newsRepository;

    @Autowired private NewsService newsService;

    @Test
    public void saveTest(){
        News news = new News(1l,"Titulo teste","descricao teste",new Date(),null);
        News newsSaved = newsRepository.save(news);

        assertThat(newsSaved.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        News news = new News(2l,"Titulo teste","descricao teste",new Date(),null);
        News newsUpdate = newsService.update(news);

        assertThat(newsUpdate.getId()).isEqualTo(2l);
    }

    @Test
    public void getByidTest(){
        Optional<News> result = newsRepository.findById(1l);
        News newsFound = result.get();

        assertThat(newsFound.getId()).isEqualTo(1l);
    }

    @Test
    public void listTest(){
        List<News> list = newsRepository.findAll();

        assertThat(list.size()).isEqualTo(2l);
    }

}
