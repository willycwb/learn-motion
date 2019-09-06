package br.com.learnmotion.models.dtos;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -1L;

	private String email;
	private String senha;

	public JwtRequest() {

	}

	public JwtRequest(String email, String senha) {
		this.setEmail(email);
		this.setSenha(senha);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}