package com.sinaukoding.abdl.entity.mapping;

import com.sinaukoding.abdl.entity.Transaksi;
import com.sinaukoding.abdl.entity.dto.TransaksiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapping {
    TransaksiMapping INSTANCE = Mappers.getMapper(TransaksiMapping.class);

    Transaksi toEntity(TransaksiDTO dto);
    TransaksiDTO toDto(Transaksi transaksi);
    List<Transaksi> toTransaksiList(List<TransaksiDTO> data);
    List<TransaksiDTO> toTransaksiDTOList(List<Transaksi> data);
}
