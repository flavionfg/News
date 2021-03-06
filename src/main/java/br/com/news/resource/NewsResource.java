package br.com.news.resource;

import br.com.news.domain.News;
import br.com.news.repository.NewsRepository;
import br.com.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "news")
public class NewsResource {

    @Autowired NewsRepository newsRepository;

    @Autowired NewsService newsService;

    @PostMapping
    public ResponseEntity<News> save(@RequestBody News news){
        News newsSaved = newsService.save(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsSaved);
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable("id") Long id){
        News result = newsService.findById(id);
        return result;
    }

    @GetMapping
    public ResponseEntity<List<News>> listAll(){
        List<News> news = newsService.listAll();
        return ResponseEntity.ok(news);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> update(@PathVariable(name = "id") Long id, @RequestBody News news) {
        news.setId(id);
        News newsUpdated = newsService.update(news);
        return ResponseEntity.ok(newsUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<News> delete(@PathVariable(name = "id") Long id){
        newsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
