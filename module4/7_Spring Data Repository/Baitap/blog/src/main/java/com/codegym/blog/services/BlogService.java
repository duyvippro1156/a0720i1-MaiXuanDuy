package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByCategory(int category_id, Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByTitleContainingAndCategory_Id(String title, int category_id ,Pageable pageable);


    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);
}
