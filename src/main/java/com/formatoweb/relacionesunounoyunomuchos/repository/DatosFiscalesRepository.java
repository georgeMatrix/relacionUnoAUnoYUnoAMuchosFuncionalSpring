package com.formatoweb.relacionesunounoyunomuchos.repository;

import com.formatoweb.relacionesunounoyunomuchos.entity.DatosFiscales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosFiscalesRepository extends JpaRepository<DatosFiscales, Long> {
}
