package br.com.learnmotion.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

public class Parent {
	
	@NotNull
	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	// TODO - SHOW
	
	/*
	 * usuarioCriacao
	 * dataAtualizacao
	 * usuarioAtualizacao
	 * 
	 * */

}
