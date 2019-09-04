package br.com.learnmotion.models.dtos;

import java.util.Set;

import br.com.learnmotion.models.Nivel;
import br.com.learnmotion.models.SubConteudo;

public class ConteudoDto {
	
	private Long id;
	
	private Nivel nivel;
	
	private Set<SubConteudo> conteudos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Set<SubConteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(Set<SubConteudo> conteudos) {
		this.conteudos = conteudos;
	}
	
	

}
