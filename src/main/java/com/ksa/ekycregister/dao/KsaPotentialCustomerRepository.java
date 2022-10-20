package com.ksa.ekycregister.dao;

import com.ksa.ekycregister.entity.KsaPotentialCustomer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsaPotentialCustomerRepository extends PagingAndSortingRepository<KsaPotentialCustomer, String> {
}