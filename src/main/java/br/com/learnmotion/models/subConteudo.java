package br.com.learnmotion.models;

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
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "SUB_CONTEUDO")
@Data
public class subConteudo {

	// TODO - SHow
	// alterar nome para subConteudo e alterar tipo para tipoconteudo
	
	@Id
	@NotNull
	@Column(name = "ID_SUB_CONTEUDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUB_CONTEUDO")
	private tipoconteudo sub_conteudo;

	@NotNull
	@Size(max = 50)
	@Column(name = "VALOR_STRING_MAIOR")
	private String valorStringMaior;

	@NotNull
	@Size(max = 100)
	@Column(name = "VALOR_STRING_MEDIO")
	private String valorStringMedio;

	@NotNull
	@Size(max = 4000)
	@Column(name = "VALOR_STRING_MENOR")
	private String valorStringMenor;

	@Lob
	@NotNull
	@Column(name = "VALOR_BLOB_IMAGEM", columnDefinition = "BLOB NULL")
	private byte[] valorBlobImagem;

	@Lob
	@NotNull
	@Column(name = "VALOR_BLOB_EXEMPLO", columnDefinition = "BLOB NULL")
	private byte[] valorBlobExemplo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public tipoconteudo getSub_conteudo() {
		return sub_conteudo;
	}

	public void setSub_conteudo(tipoconteudo sub_conteudo) {
		this.sub_conteudo = sub_conteudo;
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
