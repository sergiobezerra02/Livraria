package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
