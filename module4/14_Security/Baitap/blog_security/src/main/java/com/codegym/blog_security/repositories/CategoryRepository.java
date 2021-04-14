package com.codegym.blog_security.repositories;

import com.codegym.blog_security.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
