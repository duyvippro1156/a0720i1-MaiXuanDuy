package com.codegym.blog_security.services;

import com.codegym.blog_security.models.Blog;
import com.codegym.blog_security.models.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}

