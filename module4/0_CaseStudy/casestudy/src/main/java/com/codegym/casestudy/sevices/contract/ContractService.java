package com.codegym.casestudy.sevices.contract;

import com.codegym.casestudy.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(int id);
    Contract save(Contract contract);
    void delete(int id);
    Page<Contract> findAllByIdOrCustomerName(String search, Pageable pageable);
}
