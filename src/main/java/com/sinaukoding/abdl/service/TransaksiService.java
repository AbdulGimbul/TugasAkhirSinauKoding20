package com.sinaukoding.abdl.service;

import com.sinaukoding.abdl.entity.Transaksi;
import com.sinaukoding.abdl.entity.dto.TransaksiDTO;
import com.sinaukoding.abdl.entity.mapping.TransaksiMapping;
import com.sinaukoding.abdl.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository repository;

    public TransaksiDTO save(TransaksiDTO param){
        Transaksi transaksi = repository.save(TransaksiMapping.INSTANCE.toEntity(param));
        return TransaksiMapping.INSTANCE.toDto(transaksi);
    }

    public List<TransaksiDTO> lihatDataTransaksi(){
        return TransaksiMapping.INSTANCE.toTransaksiDTOList(repository.findAll());
    }

    public TransaksiDTO findTransaksiById(Integer id){
        return TransaksiMapping.INSTANCE.toDto(repository.findById(id).get());
    }

    public TransaksiDTO updateDataTransaksi(TransaksiDTO dto, int id){
        Transaksi referenceData = repository.findById(id).get();
        referenceData.setIdTransaksi(dto.getIdTransaksi() != null ? dto.getIdTransaksi() : referenceData.getIdTransaksi());
        referenceData.setTgl_transaksi(dto.getTgl_transaksi() != null ? dto.getTgl_transaksi() : referenceData.getTgl_transaksi());
        referenceData.setBarang(dto.getBarang() != null ? dto.getBarang() : referenceData.getBarang());
        referenceData.setKeterangan(dto.getKeterangan() != null ? dto.getKeterangan() : referenceData.getKeterangan());
        referenceData.setPembeli(dto.getPembeli() != null ? dto.getPembeli() : referenceData.getPembeli());
        referenceData.setPembayaran(dto.getPembayaran() != null ? dto.getPembayaran() : referenceData.getPembayaran());

        return TransaksiMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteDataTransaksi(int id){
        Transaksi reference = repository.findById(id).orElse(null);

        if (reference != null){
            repository.delete(reference);
            return true;
        }
        return false;
    }
}
