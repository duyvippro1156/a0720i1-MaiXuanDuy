package com.codegym.restful_blog.repositories;

import com.codegym.restful_blog.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
