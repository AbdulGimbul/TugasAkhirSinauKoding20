package com.sinaukoding.abdl.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
public class PembayaranDTO {
    private Integer idPembayaran;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date tgl_bayar;
    private Double total;
}
