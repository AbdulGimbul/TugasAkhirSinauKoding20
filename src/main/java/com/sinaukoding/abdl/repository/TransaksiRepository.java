package com.sinaukoding.abdl.repository;

import com.sinaukoding.abdl.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
}
