package com.example.springboottest.repository;

import com.example.springboottest.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test1() {
        Category category = new Category();
        category.setId(1L);
        category.setName("hello");
        Category savedCategory = categoryRepository.save(category);
        assertThat(savedCategory.getId()).isEqualTo(category.getId());
        System.out.println("result = " + savedCategory.getName());

    }



}