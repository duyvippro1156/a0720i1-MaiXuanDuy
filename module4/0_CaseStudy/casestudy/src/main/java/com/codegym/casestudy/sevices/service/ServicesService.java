package com.codegym.casestudy.sevices.service;

import com.codegym.casestudy.models.services.ServiceType;
import com.codegym.casestudy.models.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ServicesService {
    Page<Services> findAll(Pageable pageable);
    Page<Services> findAllByServiceType(ServiceType serviceType, Pageable pageable);
    Page<Services> findAllByIdOrNameContains(String search, Pageable pageable);
    Services save(Services resortService);
    Services findById(String id);
    boolean existById(String id);
    Page<Services> findByName(String name, Pageable pageable);
}
