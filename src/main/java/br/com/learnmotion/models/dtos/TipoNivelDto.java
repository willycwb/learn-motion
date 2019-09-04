package br.com.learnmotion.models.dtos;

import br.com.learnmotion.models.tipoconteudo;

public class TipoNivelDto {
	
	private Long id;
	
	private tipoconteudo tipo;
	
	private String titulo;
	
	private String subTitulo;
	
	private String descricao;
	
	private byte[] backgroud;
	
	private Long id_nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public tipoconteudo getTipo() {
		return tipo;
	}

	public void setTipo(tipoconteudo tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getBackgroud() {
		return backgroud;
	}

	public void setBackgroud(byte[] backgroud) {
		this.backgroud = backgroud;
	}

	public Long getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(Long id_nivel) {
		this.id_nivel = id_nivel;
	}
	
	

}
