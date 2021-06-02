package com.codegym.blog_ajax.repositories;

import com.codegym.blog_ajax.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
