package com.formatoweb.relacionesunounoyunomuchos.repository;

import com.formatoweb.relacionesunounoyunomuchos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
