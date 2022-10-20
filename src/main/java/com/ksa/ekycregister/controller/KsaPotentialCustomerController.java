package com.ksa.ekycregister.controller;

import com.ksa.ekycregister.dto.KsaPotentialCustomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "KsaPotentialCustomer API")
public interface KsaPotentialCustomerController {
    @ApiOperation("Add new data")
    public KsaPotentialCustomerDTO save(@RequestBody KsaPotentialCustomerDTO ksaPotentialCustomer);

    @ApiOperation("Find by Id")
    public KsaPotentialCustomerDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    public List<KsaPotentialCustomerDTO> list();

    @ApiOperation("Pagination request")
    public Page<KsaPotentialCustomerDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public KsaPotentialCustomerDTO update(@RequestBody KsaPotentialCustomerDTO dto, @PathVariable("id") String id);
}