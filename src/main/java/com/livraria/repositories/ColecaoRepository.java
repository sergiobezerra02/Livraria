package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Colecao;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao, Integer> {

}
