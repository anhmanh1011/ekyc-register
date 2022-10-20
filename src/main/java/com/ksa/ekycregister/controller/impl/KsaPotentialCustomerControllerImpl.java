package com.ksa.ekycregister.controller.impl;

import com.ksa.ekycregister.controller.KsaPotentialCustomerController;
import com.ksa.ekycregister.dto.KsaPotentialCustomerDTO;
import com.ksa.ekycregister.entity.KsaPotentialCustomer;
import com.ksa.ekycregister.mapper.KsaPotentialCustomerMapper;
import com.ksa.ekycregister.service.KsaPotentialCustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/api/ksa-potential-customer")
@RestController
public class KsaPotentialCustomerControllerImpl implements KsaPotentialCustomerController {
    private final KsaPotentialCustomerService ksaPotentialCustomerService;
    private final KsaPotentialCustomerMapper ksaPotentialCustomerMapper;

    public KsaPotentialCustomerControllerImpl(KsaPotentialCustomerService ksaPotentialCustomerService, KsaPotentialCustomerMapper ksaPotentialCustomerMapper) {
        this.ksaPotentialCustomerService = ksaPotentialCustomerService;
        this.ksaPotentialCustomerMapper = ksaPotentialCustomerMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KsaPotentialCustomerDTO save(@RequestBody KsaPotentialCustomerDTO ksaPotentialCustomerDTO) {
        KsaPotentialCustomer ksaPotentialCustomer = ksaPotentialCustomerMapper.asEntity(ksaPotentialCustomerDTO);
        ksaPotentialCustomer.setId(UUID.randomUUID().toString());
        return ksaPotentialCustomerMapper.asDTO(ksaPotentialCustomerService.save(ksaPotentialCustomer));
    }

    @Override
    @GetMapping("/{id}")
    public KsaPotentialCustomerDTO findById(@PathVariable("id") String id) {
        KsaPotentialCustomer ksaPotentialCustomer = ksaPotentialCustomerService.findById(id).orElse(null);
        return ksaPotentialCustomerMapper.asDTO(ksaPotentialCustomer);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        ksaPotentialCustomerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<KsaPotentialCustomerDTO> list() {
        return ksaPotentialCustomerMapper.asDTOList(ksaPotentialCustomerService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<KsaPotentialCustomerDTO> pageQuery(Pageable pageable) {
        Page<KsaPotentialCustomer> ksaPotentialCustomerPage = ksaPotentialCustomerService.findAll(pageable);
        List<KsaPotentialCustomerDTO> dtoList = ksaPotentialCustomerPage
                .stream()
                .map(ksaPotentialCustomerMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, ksaPotentialCustomerPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public KsaPotentialCustomerDTO update(@RequestBody KsaPotentialCustomerDTO ksaPotentialCustomerDTO, @PathVariable("id") String id) {
        KsaPotentialCustomer ksaPotentialCustomer = ksaPotentialCustomerMapper.asEntity(ksaPotentialCustomerDTO);
        return ksaPotentialCustomerMapper.asDTO(ksaPotentialCustomerService.update(ksaPotentialCustomer, id));
    }
}