package com.sinaukoding.abdl.service;

import com.sinaukoding.abdl.entity.Pembeli;
import com.sinaukoding.abdl.entity.dto.PembeliDTO;
import com.sinaukoding.abdl.entity.mapping.PembeliMapping;
import com.sinaukoding.abdl.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository repository;

    public PembeliDTO save(PembeliDTO param){
        Pembeli pembeli = repository.save(PembeliMapping.INSTANCE.toEntity(param));
        return PembeliMapping.INSTANCE.toDto(pembeli);
    }

    public List<PembeliDTO> lihatDataPembeli(){
        return PembeliMapping.INSTANCE.toPembeliDTOList(repository.findAll());
    }

    public PembeliDTO findPembeliById(Integer id){
        return PembeliMapping.INSTANCE.toDto(repository.findById(id).get());
    }

    public PembeliDTO updateDataPembeli(PembeliDTO dto, int id){
        Pembeli referenceData = repository.findById(id).get();
        referenceData.setIdPembeli(dto.getIdPembeli() != null ? dto.getIdPembeli() : referenceData.getIdPembeli());
        referenceData.setNamaPembeli(dto.getNamaPembeli() != null ? dto.getNamaPembeli() : referenceData.getNamaPembeli());
        referenceData.setAlamat(dto.getAlamat() != null ? dto.getAlamat() : referenceData.getAlamat());
        referenceData.setNoTelp(dto.getNoTelp() != null ? dto.getNoTelp() : referenceData.getNoTelp());

        return PembeliMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteDataPembeli(int id){
        Pembeli reference = repository.findById(id).orElse(null);

        if (reference != null){
            repository.delete(reference);
            return true;
        }
        return false;
    }
}
