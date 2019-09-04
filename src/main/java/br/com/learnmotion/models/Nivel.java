package br.com.learnmotion.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "NIVEL")
@Data
public class Nivel {

	@Id
	@NotNull
	@Column(name = "ID_NIVEL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "TITULO")
	private String titulo;

	@NotNull
	@Column(name = "SUB_TITULO")
	private String subTitulo;

	@NotNull
	@Column(name = "DESCRICAO")
	private String descricao;

	@Lob
	@NotNull
	@Column(name = "BACKGROUD", columnDefinition = "BLOB")
	private byte[] backgroud;
	
	// TODO - SHOW
//	private List<Conteudo> conteudos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
