package br.com.learnmotion.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "CONTEUDO")
@Data
public class Conteudo extends Parent {

	@Id
	@NotNull
	@Column(name = "ID_CONTEUDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NIVEL")
	private Nivel nivel;

	@ManyToMany
	@JoinTable(name = "CONTEUDO_TIPO_CONTEUDO", joinColumns = {
			@JoinColumn(name = "ID_CONTEUDO") }, inverseJoinColumns = { @JoinColumn(name = "ID_TIPO_CONTEUDO") })
	private Set<subConteudo> conteudos = new HashSet<>();

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
