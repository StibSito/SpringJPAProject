package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
