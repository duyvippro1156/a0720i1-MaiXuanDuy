package com.codegym.casestudy.sevices.service;

import com.codegym.casestudy.models.services.AttachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttachServiceService {
    List<AttachService> findAll();
    AttachService findById(int id);
}
