package com.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.domain.DireitoAutoral;

@Repository
public interface DireitoAutoralRepository extends JpaRepository<DireitoAutoral, Integer>{

}
