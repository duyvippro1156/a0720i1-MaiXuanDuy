package com.codegym.restful_blog.services;

import com.codegym.restful_blog.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}

