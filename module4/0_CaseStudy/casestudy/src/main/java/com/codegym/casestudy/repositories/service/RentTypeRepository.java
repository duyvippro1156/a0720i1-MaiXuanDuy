package com.codegym.casestudy.repositories.service;

import com.codegym.casestudy.models.services.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
