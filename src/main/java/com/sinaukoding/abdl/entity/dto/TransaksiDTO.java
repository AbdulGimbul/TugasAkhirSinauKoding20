package com.sinaukoding.abdl.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinaukoding.abdl.entity.Barang;
import com.sinaukoding.abdl.entity.Pembayaran;
import com.sinaukoding.abdl.entity.Pembeli;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
public class TransaksiDTO {
    private Integer idTransaksi;
    private Barang barang;
    private Pembeli pembeli;
    private Pembayaran pembayaran;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tgl_transaksi;
    private String keterangan;
}
