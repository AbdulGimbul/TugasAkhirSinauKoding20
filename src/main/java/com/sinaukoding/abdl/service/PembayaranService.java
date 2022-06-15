package com.sinaukoding.abdl.service;

import com.sinaukoding.abdl.entity.Pembayaran;
import com.sinaukoding.abdl.entity.dto.PembayaranDTO;
import com.sinaukoding.abdl.entity.mapping.PembayaranMapping;
import com.sinaukoding.abdl.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository repository;

    public PembayaranDTO save(PembayaranDTO param){
        Pembayaran pembayaran = repository.save(PembayaranMapping.INSTANCE.toEntity(param));
        return PembayaranMapping.INSTANCE.toDto(pembayaran);
    }

    public List<PembayaranDTO> lihatDataPembayaran(){
        return PembayaranMapping.INSTANCE.toPembayaranDTOList(repository.findAll());
    }

    public PembayaranDTO findPembayaranById(Integer id){
        return PembayaranMapping.INSTANCE.toDto(repository.findById(id).get());
    }

    public PembayaranDTO updateDataPembayaran(PembayaranDTO dto, int id){
        Pembayaran referenceData = repository.findById(id).get();
        referenceData.setIdPembayaran(dto.getIdPembayaran() != null ? dto.getIdPembayaran() : referenceData.getIdPembayaran());
        referenceData.setTgl_bayar(dto.getTgl_bayar() != null ? dto.getTgl_bayar() : referenceData.getTgl_bayar());
        referenceData.setTotal(dto.getTotal() != null ? dto.getTotal() : referenceData.getTotal());

        return PembayaranMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteDataPembayaran(int id){
        Pembayaran reference = repository.findById(id).orElse(null);

        if (reference != null){
            repository.delete(reference);
            return true;
        }

        return false;
    }
}
