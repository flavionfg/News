package br.com.news.service;

import br.com.news.domain.Category;
import br.com.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired CategoryRepository categoryRepository;

    public Category save(Category request){
        Category categorySaved = categoryRepository.save(request);
        return categorySaved;
    }

    public Category findById(Long id){
        Optional<Category> result = categoryRepository.findById(id);
        return result.get();
    }

    public List<Category> listAll(){
        List<Category> list = categoryRepository.findAll();
        return list;
    }

    public Category update(Category category){
        Category categoryUpdated = categoryRepository.save(category);
        return categoryUpdated;
    }

    public void delete(Long id){
        Category categoryDeleted = findById(id);
        categoryRepository.delete(categoryDeleted);
    }
}
