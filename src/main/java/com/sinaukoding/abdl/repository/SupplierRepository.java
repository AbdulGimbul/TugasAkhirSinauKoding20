package com.sinaukoding.abdl.repository;

import com.sinaukoding.abdl.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findByNamaSupplierContaining(String nama);
}
