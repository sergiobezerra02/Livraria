package com.livraria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Colecao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "LIVRO_COLECAO",
	           joinColumns = @JoinColumn(name = "colecao_id"),
	           inverseJoinColumns = @JoinColumn(name = "livro_id"))
	private List<Livro> livros = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "departamento_leitura_id")
	private Departamento departamentoLeitura;
	
	public Colecao() {
		super();
	}

	public Colecao(Integer id, String nome, Departamento departamentoLeitura) {
		super();
		this.id = id;
		this.nome = nome;
		this.departamentoLeitura = departamentoLeitura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public Departamento getDepartamentoLeitura() {
		return departamentoLeitura;
	}

	public void setDepartamentoLeitura(Departamento departamentoLeitura) {
		this.departamentoLeitura = departamentoLeitura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colecao other = (Colecao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
