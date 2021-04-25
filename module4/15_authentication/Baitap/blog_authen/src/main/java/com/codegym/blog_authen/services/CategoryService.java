package com.codegym.blog_authen.services;

import com.codegym.blog_authen.models.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}

