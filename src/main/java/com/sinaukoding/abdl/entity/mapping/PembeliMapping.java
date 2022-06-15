package com.sinaukoding.abdl.entity.mapping;

import com.sinaukoding.abdl.entity.Pembeli;
import com.sinaukoding.abdl.entity.dto.PembeliDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapping {
    PembeliMapping INSTANCE = Mappers.getMapper(PembeliMapping.class);

    Pembeli toEntity(PembeliDTO dto);
    PembeliDTO toDto(Pembeli pembeli);
    List<Pembeli> toPembeliList(List<PembeliDTO> data);
    List<PembeliDTO> toPembeliDTOList(List<Pembeli> data);
}
