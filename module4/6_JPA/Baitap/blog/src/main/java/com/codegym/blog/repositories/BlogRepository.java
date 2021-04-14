package com.codegym.blog.repositories;

import com.codegym.blog.models.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
}
