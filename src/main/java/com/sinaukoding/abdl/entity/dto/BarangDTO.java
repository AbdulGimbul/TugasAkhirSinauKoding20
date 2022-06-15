package com.sinaukoding.abdl.entity.dto;

import com.sinaukoding.abdl.entity.Supplier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class BarangDTO {
    private Integer idBarang;
    private String namaBarang;
    private Double harga;
    private Integer stok;
    private Supplier supplier;
}
