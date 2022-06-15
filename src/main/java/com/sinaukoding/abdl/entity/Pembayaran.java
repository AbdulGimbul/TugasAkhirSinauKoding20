package com.sinaukoding.abdl.entity;

        import lombok.Getter;
        import lombok.Setter;

        import javax.persistence.*;
        import java.util.Date;

@Entity
@Table(name = "tbl_pembayaran")
@Setter
@Getter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private Integer idPembayaran;

    @Column(name = "tgl_bayar")
    private Date tgl_bayar;

    @Column(name = "total")
    private Double total;
}
