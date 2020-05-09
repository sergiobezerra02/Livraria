package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
