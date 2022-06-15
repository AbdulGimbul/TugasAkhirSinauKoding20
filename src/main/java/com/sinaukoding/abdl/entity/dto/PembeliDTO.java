package com.sinaukoding.abdl.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class PembeliDTO {
    private Integer idPembeli;
    private String namaPembeli;
    private String noTelp;
    private String alamat;
}
