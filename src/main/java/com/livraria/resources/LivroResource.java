package com.livraria.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.domain.Livro;
import com.livraria.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Livro livro = livroService.buscar(id);
		return ResponseEntity.ok().body(livro);
	}

}
