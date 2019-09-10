package br.com.learnmotion.models.dtos;

public class SubConteudoDto {

	private Long id;

	private TipoConteudoDto tipoConteudo;

	private String valorStringMaior;

	private String valorStringMedio;

	private String valorStringMenor;

	private byte[] valorBlobImagem;

	private byte[] valorBlobExemplo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoConteudoDto getTipoConteudo() {
		return tipoConteudo;
	}

	public void setTipoConteudo(TipoConteudoDto tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

	public String getValorStringMaior() {
		return valorStringMaior;
	}

	public void setValorStringMaior(String valorStringMaior) {
		this.valorStringMaior = valorStringMaior;
	}

	public String getValorStringMedio() {
		return valorStringMedio;
	}

	public void setValorStringMedio(String valorStringMedio) {
		this.valorStringMedio = valorStringMedio;
	}

	public String getValorStringMenor() {
		return valorStringMenor;
	}

	public void setValorStringMenor(String valorStringMenor) {
		this.valorStringMenor = valorStringMenor;
	}

	public byte[] getValorBlobImagem() {
		return valorBlobImagem;
	}

	public void setValorBlobImagem(byte[] valorBlobImagem) {
		this.valorBlobImagem = valorBlobImagem;
	}

	public byte[] getValorBlobExemplo() {
		return valorBlobExemplo;
	}

	public void setValorBlobExemplo(byte[] valorBlobExemplo) {
		this.valorBlobExemplo = valorBlobExemplo;
	}

}
