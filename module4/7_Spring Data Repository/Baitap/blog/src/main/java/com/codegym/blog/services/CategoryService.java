package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import com.codegym.blog.models.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}

