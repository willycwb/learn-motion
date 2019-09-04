package br.com.learnmotion.models.dtos;

import java.util.Set;

import br.com.learnmotion.models.Nivel;
import br.com.learnmotion.models.subConteudo;

public class ConteudoDto {
	
	private Long id;
	
	private Nivel nivel;
	
	private Set<subConteudo> conteudos;

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

	public Set<subConteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(Set<subConteudo> conteudos) {
		this.conteudos = conteudos;
	}
	
	

}
