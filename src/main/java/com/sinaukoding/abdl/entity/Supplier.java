package com.sinaukoding.abdl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_supplier")
@Setter
@Getter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Integer idSupplier;

    @Column(name = "nama_supplier")
    private String namaSupplier;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "alamat")
    private String alamat;
}
