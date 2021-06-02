package com.codegym.casestudy.repositories.service;

import com.codegym.casestudy.models.services.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}