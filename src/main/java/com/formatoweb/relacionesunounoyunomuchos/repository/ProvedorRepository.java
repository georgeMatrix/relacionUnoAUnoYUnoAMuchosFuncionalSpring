package com.formatoweb.relacionesunounoyunomuchos.repository;

import com.formatoweb.relacionesunounoyunomuchos.entity.Provedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvedorRepository extends JpaRepository<Provedor, Long> {
}
