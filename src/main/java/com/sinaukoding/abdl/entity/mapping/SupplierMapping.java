package com.sinaukoding.abdl.entity.mapping;

import com.sinaukoding.abdl.entity.Supplier;
import com.sinaukoding.abdl.entity.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapping {
    SupplierMapping INSTANCE = Mappers.getMapper(SupplierMapping.class);

    Supplier toEntity(SupplierDTO dto);
    SupplierDTO toDto(Supplier supplier);
    List<Supplier> toSupplierList(List<SupplierDTO> data);
    List<SupplierDTO> toSupplierDTOList(List<Supplier> data);
}
