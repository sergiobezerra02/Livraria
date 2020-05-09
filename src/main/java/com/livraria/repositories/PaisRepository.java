package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{

}
