package com.sinaukoding.abdl.service;

import com.sinaukoding.abdl.entity.Barang;
import com.sinaukoding.abdl.entity.dto.BarangDTO;
import com.sinaukoding.abdl.entity.mapping.BarangMapping;
import com.sinaukoding.abdl.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {

    @Autowired
    BarangRepository repository;

    public BarangDTO save(BarangDTO param){
        Barang barang = repository.save(BarangMapping.INSTANCE.toEntity(param));
        return BarangMapping.INSTANCE.toDto(barang);
    }

    public List<BarangDTO> lihatDataBarang(){
        return BarangMapping.INSTANCE.toBarangDTOList(repository.findAll());
    }

    public BarangDTO findBarangById(Integer id){
        return BarangMapping.INSTANCE.toDto(repository.findById(id).get());
    }

    public BarangDTO updateDataBarang(BarangDTO dto, Integer id){
        Barang referenceData = repository.findById(id).get();
        referenceData.setNamaBarang(dto.getNamaBarang() != null ? dto.getNamaBarang() : referenceData.getNamaBarang());
        referenceData.setHarga(dto.getHarga() != null ? dto.getHarga() : referenceData.getHarga());
        referenceData.setStok(dto.getStok() != null ? dto.getStok() : referenceData.getStok());

        return BarangMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteDataBarang(int id){
        Barang reference = repository.findById(id).orElse(null);

        if (reference != null){
            repository.delete(reference);
            return true;
        }
        return false;
    }

}
