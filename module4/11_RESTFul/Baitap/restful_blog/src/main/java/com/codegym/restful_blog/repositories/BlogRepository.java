package com.codegym.restful_blog.repositories;

import com.codegym.restful_blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    List<Blog> findAll();
//    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory_Id(int category_id, Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByTitleContainingAndCategory_Id(String title, int category_id, Pageable pageable);
}
