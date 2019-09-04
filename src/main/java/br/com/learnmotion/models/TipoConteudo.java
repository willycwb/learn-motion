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
@Table(name = "TIPO_CONTEUDO")
@Data
public class TipoConteudo {

	// TODO - SHow
	// alterar nome para subConteudo e alterar tipo para tipoconteudo
	
	@Id
	@NotNull
	@Column(name = "ID_TIPO_CONTEUDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO")
	private Tipo tipo;

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

}
