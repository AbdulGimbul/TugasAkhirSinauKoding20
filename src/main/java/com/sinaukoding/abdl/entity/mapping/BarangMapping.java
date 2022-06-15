package com.sinaukoding.abdl.entity.mapping;

import com.sinaukoding.abdl.entity.Barang;
import com.sinaukoding.abdl.entity.dto.BarangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapping {
    BarangMapping INSTANCE = Mappers.getMapper(BarangMapping.class);

    Barang toEntity(BarangDTO dto);
    BarangDTO toDto(Barang barang);
    List<Barang> toBarangList(List<BarangDTO> data);
    List<BarangDTO> toBarangDTOList(List<Barang> data);
}
