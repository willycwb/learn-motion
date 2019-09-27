package br.com.learnmotion.common.enums;

public enum Status {
	
	SUCESSO("Sucesso"),
    ERRO("Erro");
	
	String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
