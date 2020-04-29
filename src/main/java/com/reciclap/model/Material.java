package com.reciclap.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="TB_MATERIAL")
public class Material  implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idMaterial;
	
	public String nome;
	private String composicao;
	private String tipo;
	private String decomposicao;
	private boolean reciclado;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Empresa empresa;
	
	public Empresa empresa(){
		return empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getComposicao() {
		return composicao;
	}
	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
