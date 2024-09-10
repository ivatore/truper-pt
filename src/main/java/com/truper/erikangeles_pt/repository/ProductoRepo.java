package com.truper.erikangeles_pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truper.erikangeles_pt.model.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

}
