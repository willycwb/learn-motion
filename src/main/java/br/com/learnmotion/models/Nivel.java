package br.com.learnmotion.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NIVEL")
public class Nivel extends Parent {

	@Id
	@NotNull
	@Column(name = "ID_NIVEL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_NIVEL")
	private TipoNivel tipoNivel;

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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.LAZY)
	private List<Conteudo> conteudos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoNivel getTipoNivel() {
		return tipoNivel;
	}

	public void setTipoNivel(TipoNivel tipoNivel) {
		this.tipoNivel = tipoNivel;
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

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

}
