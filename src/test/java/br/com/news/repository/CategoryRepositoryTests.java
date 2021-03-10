package br.com.news.repository;


import br.com.news.domain.Category;
import br.com.news.service.CategoryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTests {

    @Autowired private CategoryRepository categoryRepository;

    @Autowired private CategoryService categoryService;

    @Test
    public void saveTest() {
        Category category = new Category(1l,"Categoria Teste",null);
        Category categoryCreated = categoryRepository.save(category);

        assertThat(categoryCreated.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        Category category = new Category(2l,"Categoria Teste",null);
        Category categoryUpdated = categoryService.update(category);

        assertThat(categoryUpdated.getId()).isEqualTo(2l);
    }

    @Test
    public void getByIdTest(){
        Optional<Category> result = categoryRepository.findById(2l);
        Category categoryFound = result.get();
        assertThat(categoryFound.getId()).isEqualTo(2l);
    }

    @Test
    public void listTest(){
        List<Category> categoryList = categoryRepository.findAll();

        assertThat(categoryList.size()).isEqualTo(2l);
    }
}
