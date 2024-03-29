package com.codegym.phonemanagement.repository;

import com.codegym.phonemanagement.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
