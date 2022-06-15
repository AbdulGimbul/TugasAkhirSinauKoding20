package com.sinaukoding.abdl.entity.mapping;

import com.sinaukoding.abdl.entity.Pembayaran;
import com.sinaukoding.abdl.entity.dto.PembayaranDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapping {
    PembayaranMapping INSTANCE = Mappers.getMapper(PembayaranMapping.class);

    Pembayaran toEntity(PembayaranDTO dto);
    PembayaranDTO toDto(Pembayaran pembayaran);
    List<Pembayaran> toPembayaranList(List<PembayaranDTO> data);
    List<PembayaranDTO> toPembayaranDTOList(List<Pembayaran> data);
}
