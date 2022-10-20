package com.ksa.ekycregister.mapper;

import com.ksa.ekycregister.dto.KsaPotentialCustomerDTO;
import com.ksa.ekycregister.entity.KsaPotentialCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface KsaPotentialCustomerMapper extends GenericMapper<KsaPotentialCustomer, KsaPotentialCustomerDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    KsaPotentialCustomer asEntity(KsaPotentialCustomerDTO dto);
}