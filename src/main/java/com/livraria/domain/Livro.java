package com.livraria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.enums.EstadoLivro;

@Entity
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer ano;
	private Integer estadoLivro;
	private Double multa;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "livro")
	private Emprestimo emprestimo;
	

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;
	
	@OneToMany(mappedBy = "id.livro")
	private Set<DireitoAutoral> direitoAutoral = new HashSet<>();
	
	@ManyToMany(mappedBy = "livros")
	private List<Colecao> colecoes = new ArrayList<>();
	
	
	public Livro() {
		super();
	}
	
	public Livro(Integer id, String nome, Integer ano, EstadoLivro estadoLivro, Double multa, Editora editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano = ano;
		this.estadoLivro = estadoLivro.getCodigo();
		this.multa = multa;
		this.editora = editora;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public EstadoLivro getEstadoLivro() {
		return EstadoLivro.toEnum(this.estadoLivro);
	}

	public void setEstadoLivro(EstadoLivro estadoLivro) {
		this.estadoLivro = estadoLivro.getCodigo();
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public Set<DireitoAutoral> getDireitoAutoral() {
		return direitoAutoral;
	}

	public void setDireitoAutoral(Set<DireitoAutoral> direitoAutoral) {
		this.direitoAutoral = direitoAutoral;
	}
	
	public void setColecoes(List<Colecao> colecoes) {
		this.colecoes = colecoes;
	}

	public void setEstadoLivro(Integer estadoLivro) {
		this.estadoLivro = estadoLivro;
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
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Colecao> getColecoes() {
		return colecoes;
	}


}
