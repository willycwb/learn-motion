package br.com.learnmotion.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TIPO_CONTEUDO")
@Data
public class tipoconteudo {

	@Id
	@NotNull
	@Column(name = "ID_TIPO_CONTEUDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_CONTEUDO")
	private tipoconteudo tipo_conteudo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public tipoconteudo getTipo_conteudo() {
		return tipo_conteudo;
	}

	public void setTipo_conteudo(tipoconteudo tipo_conteudo) {
		this.tipo_conteudo = tipo_conteudo;
	}	

}
