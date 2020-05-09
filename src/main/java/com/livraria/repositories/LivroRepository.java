package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
