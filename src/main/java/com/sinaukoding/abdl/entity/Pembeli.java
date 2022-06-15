package com.sinaukoding.abdl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_pembeli")
@Setter
@Getter
public class Pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembeli")
    private Integer idPembeli;

    @Column(name = "nama_pembeli")
    private String namaPembeli;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "alamat")
    private String alamat;
}
