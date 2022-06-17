package com.sinaukoding.abdl.repository;

import com.sinaukoding.abdl.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarangRepository extends JpaRepository<Barang, Integer> {
    List<Barang> findByNamaBarangContaining(String nama);
}
