package meubar.estoque.json.pojo;

import meubar.json.pojo.JsonBase;

public class ProdutoJson extends JsonBase {

	private String nome;
	private String categoria;
	private Long categoriaId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
