package com.livraria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.domain.Livro;
import com.livraria.repositories.LivroRepository;
import com.livraria.services.exception.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public Livro buscar(Integer id) {
		
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Objeto id: " + id + " não encontrado.  "
				+ "Tipo: " +  Livro.class.getName()));
	}
	

}
