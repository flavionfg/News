package br.com.news.resource;

import br.com.news.domain.Category;
import br.com.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "category")
public class CategoryResorce {

    @Autowired CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        Category categorySalva = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySalva);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") Long id){
        Category result = categoryService.findById(id);
        return result;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> listAll(){
        List<Category> categories = categoryService.listAll();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable(name = "id") Long id, @RequestBody Category category){
        category.setId(id);
        Category categoryUpdated = categoryService.update(category);
        return ResponseEntity.ok(categoryUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
