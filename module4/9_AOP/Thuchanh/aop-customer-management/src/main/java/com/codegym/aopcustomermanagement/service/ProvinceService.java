package com.codegym.aopcustomermanagement.service;

import com.codegym.aopcustomermanagement.model.Province;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
