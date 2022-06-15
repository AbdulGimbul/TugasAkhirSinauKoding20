package com.sinaukoding.abdl.service;

import com.sinaukoding.abdl.entity.Supplier;
import com.sinaukoding.abdl.entity.dto.SupplierDTO;
import com.sinaukoding.abdl.entity.mapping.SupplierMapping;
import com.sinaukoding.abdl.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository repository;

    public SupplierDTO save(SupplierDTO param){
        Supplier supplier = repository.save(SupplierMapping.INSTANCE.toEntity(param));
        return SupplierMapping.INSTANCE.toDto(supplier);
    }

    public List<SupplierDTO> lihatDataSupplier(){
        return SupplierMapping.INSTANCE.toSupplierDTOList(repository.findAll());
    }

    public SupplierDTO findSupplierById(Integer id){
        return SupplierMapping.INSTANCE.toDto(repository.findById(id).get());
    }

    public SupplierDTO updateDataSupplier(SupplierDTO dto, int id){
        Supplier referenceData = repository.findById(id).get();
        referenceData.setIdSupplier(dto.getIdSupplier() != null ? dto.getIdSupplier() : referenceData.getIdSupplier());
        referenceData.setNamaSupplier(dto.getNamaSupplier() != null ? dto.getNamaSupplier() : referenceData.getNamaSupplier());
        referenceData.setAlamat(dto.getAlamat() != null ? dto.getAlamat() : referenceData.getAlamat());
        referenceData.setNoTelp(dto.getNoTelp() != null ? dto.getNoTelp() : referenceData.getNoTelp());

        return SupplierMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteDataSupplier(int id){
        Supplier reference = repository.findById(id).orElse(null);

        if (reference != null){
            repository.delete(reference);
            return true;
        }
        return false;
    }
}
