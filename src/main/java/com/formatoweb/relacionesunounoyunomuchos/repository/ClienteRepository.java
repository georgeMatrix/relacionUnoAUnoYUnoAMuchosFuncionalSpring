package com.formatoweb.relacionesunounoyunomuchos.repository;

import com.formatoweb.relacionesunounoyunomuchos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
