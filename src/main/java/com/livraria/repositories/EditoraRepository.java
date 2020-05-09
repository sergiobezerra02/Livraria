package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer>{

}
