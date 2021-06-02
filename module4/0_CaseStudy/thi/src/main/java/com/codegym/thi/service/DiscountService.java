package com.codegym.thi.service;

import com.codegym.thi.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    List<Discount> findAll();
    List<Discount> findAllByDiscount(String title);
    Discount findById(int id);
    Discount save(Discount discount);
    void delete (int id);
}
