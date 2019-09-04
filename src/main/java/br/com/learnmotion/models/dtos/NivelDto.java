package br.com.learnmotion.models.dtos;

public class NivelDto {

	private Long id;

	private TipoNivelDto tipoNivel;

	private String titulo;

	private String subTitulo;

	private String descricao;

	private byte[] backgroud;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoNivelDto getTipoNivel() {
		return tipoNivel;
	}

	public void setTipoNivel(TipoNivelDto tipoNivel) {
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

}
