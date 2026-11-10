package com.example.capcatalog.repository;

import com.example.capcatalog.entity.PromocionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocionUsuarioRepository
        extends JpaRepository<PromocionUsuario, Long> {
}