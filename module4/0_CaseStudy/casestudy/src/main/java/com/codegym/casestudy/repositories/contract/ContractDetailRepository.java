package com.codegym.casestudy.repositories.contract;

import com.codegym.casestudy.models.contract.ContractDetail;
import com.codegym.casestudy.models.contract.ContractDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, ContractDetailKey> {
    List<ContractDetail> findAllByContract_Id(int contractId);
    void deleteAllByContract_Id(int contractId);
}
