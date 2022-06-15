package com.sinaukoding.abdl.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_transaksi")
@Setter
@Getter
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer idTransaksi;

    @JsonIgnoreProperties(value = {"barangList", "handle", "hibernateLazyInitializer"},
        allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @JsonIgnoreProperties(value = {"pembeliList", "handle", "hibernateLazyInitializer"},
        allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @JsonIgnoreProperties(value = {"pembayaranList", "handle", "hibernateLazyInitializer"},
        allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_pembayaran")
    private Pembayaran pembayaran;

    @Column(name = "tgl_transaksi")
    private Date tgl_transaksi;

    @Column(name = "keterangan")
    private String keterangan;
}
