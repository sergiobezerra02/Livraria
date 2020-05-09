package com.livraria.enums;


public enum EstadoLivro {
	
	EMPRESTADO(1, "Emprestado"),
	DISPONIVEL(2, "Disponível"),
	INUTILIZADO(3, "Inutilizado");
	
	private int codigo;
	private String status;
	
	
	private EstadoLivro(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public static EstadoLivro toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		
		for(EstadoLivro x: EstadoLivro.values()) {
			
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("Código inválido: " + codigo);
		
		
	}
	
	

}
