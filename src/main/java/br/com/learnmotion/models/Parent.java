package br.com.learnmotion.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "PARENT")
@Data
public class Parent {
	
	@Id
	@NotNull
	@Column(name = "ID_PARENT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@NotNull
	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@NotNull
	@JoinColumn(name = "USUARIO", referencedColumnName = "ID_USUARIO")
	@Column(name = "USUARIO_CRIACAO")
	private boolean usuarioCriacao;

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public boolean isUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(boolean usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}
	
	// TODO - SHOW
	
	/*
	 * usuarioCriacao
	 * dataAtualizacao
	 * usuarioAtualizacao
	 * 
	 * */
	
	

}
