package br.com.learnmotion.models.dtos;

import lombok.Data;

@Data
public class PessoaDto {

	private Long id;

	private String nome;

	private Long idade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

}
