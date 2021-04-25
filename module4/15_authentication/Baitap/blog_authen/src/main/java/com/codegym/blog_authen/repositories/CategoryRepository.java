package com.codegym.blog_authen.repositories;

import com.codegym.blog_authen.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
