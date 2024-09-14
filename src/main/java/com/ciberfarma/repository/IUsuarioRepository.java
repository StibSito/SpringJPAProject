package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

}
