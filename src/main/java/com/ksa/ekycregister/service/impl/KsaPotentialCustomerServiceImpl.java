package com.ksa.ekycregister.service.impl;

import com.ksa.ekycregister.dao.KsaPotentialCustomerRepository;
import com.ksa.ekycregister.dto.KsaPotentialCustomerDTO;
import com.ksa.ekycregister.entity.KsaPotentialCustomer;
import com.ksa.ekycregister.mapper.KsaPotentialCustomerMapper;
import com.ksa.ekycregister.service.KsaPotentialCustomerService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KsaPotentialCustomerServiceImpl implements KsaPotentialCustomerService {
    private final KsaPotentialCustomerRepository repository;

    public KsaPotentialCustomerServiceImpl(KsaPotentialCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public KsaPotentialCustomer save(KsaPotentialCustomer entity) {
        return repository.save(entity);
    }

    @Override
    public List<KsaPotentialCustomer> save(List<KsaPotentialCustomer> entities) {
        return (List<KsaPotentialCustomer>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<KsaPotentialCustomer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<KsaPotentialCustomer> findAll() {
        return (List<KsaPotentialCustomer>) repository.findAll();
    }

    @Override
    public Page<KsaPotentialCustomer> findAll(Pageable pageable) {
        Page<KsaPotentialCustomer> entityPage = repository.findAll(pageable);
        List<KsaPotentialCustomer> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public KsaPotentialCustomer update(KsaPotentialCustomer entity, String id) {
        Optional<KsaPotentialCustomer> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}