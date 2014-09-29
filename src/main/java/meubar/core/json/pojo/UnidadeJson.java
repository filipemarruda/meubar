package meubar.core.json.pojo;

import meubar.json.pojo.JsonBase;

public class UnidadeJson extends JsonBase {

	private String sigla;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
