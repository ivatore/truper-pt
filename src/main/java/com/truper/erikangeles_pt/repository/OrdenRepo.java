package com.truper.erikangeles_pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truper.erikangeles_pt.model.Orden;

@Repository
public interface OrdenRepo extends JpaRepository<Orden, Integer> {

}
