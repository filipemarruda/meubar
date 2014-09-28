package meubar.core.json.pojo;

import meubar.json.pojo.JsonBase;

public class EstadoJson extends JsonBase {

	private String uf;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
