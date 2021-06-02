package com.codegym.casestudy.repositories.service;

import com.codegym.casestudy.models.services.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {
}
