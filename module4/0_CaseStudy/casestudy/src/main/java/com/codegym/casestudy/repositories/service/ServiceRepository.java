package com.codegym.casestudy.repositories.service;

import com.codegym.casestudy.models.services.Services;
import com.codegym.casestudy.models.services.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services, String> {
    Page<Services> findAll(Pageable pageable);
    Page<Services> findAllByNameContains(String name, Pageable pageable);
    Page<Services> findAllByServiceType(ServiceType serviceType, Pageable pageable);
    Page<Services> findAllByIdContainsOrNameContains(String id, String name, Pageable pageable);
}
