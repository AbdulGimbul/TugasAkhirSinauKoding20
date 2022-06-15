package com.sinaukoding.abdl.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_barang")
@Setter
@Getter
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang")
    private Integer idBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga")
    private Double harga;

    @Column(name = "stok")
    private Integer stok;

    @JsonIgnoreProperties(value = {"supplierList", "handle", "hibernateLazyInitializer"},
        allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

}
