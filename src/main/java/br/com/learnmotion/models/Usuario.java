package br.com.learnmotion.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "USUARIO")
@Data
public class Usuario {

	@Id
	@NotNull
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "NOME")
	private String nome;

	@NotNull
	@Column(name = "EMAIL")
	private String email;

	@NotNull
	@Column(name = "SENHA")
	private String senha;

	@NotNull
	@Column(name = "TOKEN")
	private String token;

}
