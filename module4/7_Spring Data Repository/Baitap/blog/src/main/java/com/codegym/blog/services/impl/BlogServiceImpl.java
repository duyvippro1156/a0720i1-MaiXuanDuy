package com.codegym.blog.services.impl;

import com.codegym.blog.models.Blog;
import com.codegym.blog.repositories.BlogRepository;
import com.codegym.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(int category_id, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(category_id, pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContainingAndCategory_Id(String title, int category_id, Pageable pageable) {
        return blogRepository.findAllByTitleContainingAndCategory_Id(title, category_id, pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
