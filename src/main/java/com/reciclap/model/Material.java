package com.reciclap.model;

public class Material {

	private long id;
	private String name;
	private String Composicao;
	private String Tipo;
	private String decomposicao;
	private boolean reciclado;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposicao() {
		return Composicao;
	}
	public void setComposicao(String composicao) {
		Composicao = composicao;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getDecomposicao() {
		return decomposicao;
	}
	public void setDecomposicao(String decomposicao) {
		this.decomposicao = decomposicao;
	}
	public boolean isReciclado() {
		return reciclado;
	}
	public void setReciclado(boolean reciclado) {
		this.reciclado = reciclado;
	}
	
	
	
}
