package com.livraria.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DireitoAutoral implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private DireitoAutoralPk id = new DireitoAutoralPk();
	
	private Double valor;
	
    public DireitoAutoral() {
    	super();
    }
    
    
    public DireitoAutoral(Autor autor, Livro livro, Double valor) {
		super();
		this.id.setAutor(autor);
		this.id.setLivro(livro);
		this.valor = valor;
	}
    
   
    public Autor getAutor() {
    	return id.getAutor();
    }
    
    @JsonIgnore
    public Livro getLivro() {
    	return id.getLivro();
    }

	public DireitoAutoralPk getId() {
		return id;
	}

	public void setId(DireitoAutoralPk id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		DireitoAutoral other = (DireitoAutoral) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
