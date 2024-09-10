package com.truper.erikangeles_pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.erikangeles_pt.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

}
