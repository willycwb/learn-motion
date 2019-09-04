package br.com.learnmotion.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TIPO_NIVEL")
@Data
public class TipoNivel {

	@Id
	@NotNull
	@Column(name = "ID_TIPO_NIVEL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO")
	private tipoconteudo tipo;
	
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
	
	@NotNull
	@JoinColumn(name = "NIVEL", referencedColumnName = "ID_NIVEL")
	@Column(name = "ID_NIVEL")
	private Long id_nivel;
	
	// TODO - SHOW
	//private List<Conteudo> conteudos;

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
