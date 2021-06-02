package com.codegym.thi.repository;

import com.codegym.thi.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    @Query("SELECT e FROM Discount e WHERE e.title LIKE ?1 OR e.discounts = ?2")
    List<Discount> findAllByTitleContainingOrDiscountsContaining(int discount, String name);
    List<Discount> findAllByTitleContaining(String search);
}
