package com.sinaukoding.abdl.repository;

import com.sinaukoding.abdl.entity.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PembeliRepository extends JpaRepository<Pembeli, Integer> {
    List<Pembeli> findByNamaPembeliContaining(String nama);

    Integer countByNamaPembeliContaining(String nama);
}
