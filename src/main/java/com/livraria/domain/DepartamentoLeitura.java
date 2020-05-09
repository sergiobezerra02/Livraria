package com.livraria.domain;

import javax.persistence.Entity;

@Entity
public class DepartamentoLeitura extends Departamento {
	private static final long serialVersionUID = 1L;
	
    private String classificacao;

	public DepartamentoLeitura() {
		super();
	}

	public DepartamentoLeitura(Integer id, String nome, String classificacao) {
		super(id, nome);
		this.classificacao = classificacao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
    
    
}
