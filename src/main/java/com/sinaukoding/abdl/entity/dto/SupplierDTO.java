package com.sinaukoding.abdl.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class SupplierDTO {
    private Integer idSupplier;
    private String namaSupplier;
    private String noTelp;
    private String alamat;
}
