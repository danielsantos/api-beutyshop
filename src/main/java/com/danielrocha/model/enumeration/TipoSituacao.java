package com.danielrocha.model.enumeration;

public enum TipoSituacao {

	A("Ativo","A"), 
	I("Inativo","I"); 
	
	private final String descricao;
	private final String codigo;
	
	TipoSituacao(String descricao, String codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
}
