package com.codegym.blog_ajax.repositories;

import com.codegym.blog_ajax.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory_Id(int category_id, Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByTitleContainingAndCategory_Id(String title, int category_id, Pageable pageable);
}
