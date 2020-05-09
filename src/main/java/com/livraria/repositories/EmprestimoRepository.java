package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

}
