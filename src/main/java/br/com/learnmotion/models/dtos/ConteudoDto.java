package br.com.learnmotion.models.dtos;

import java.util.List;

public class ConteudoDto {

	private Long id;

	private NivelDto nivel;

	private List<SubConteudoDto> conteudos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NivelDto getNivel() {
		return nivel;
	}

	public void setNivel(NivelDto nivel) {
		this.nivel = nivel;
	}

	public List<SubConteudoDto> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<SubConteudoDto> conteudos) {
		this.conteudos = conteudos;
	}

}
