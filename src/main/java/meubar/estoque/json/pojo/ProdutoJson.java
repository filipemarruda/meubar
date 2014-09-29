package meubar.estoque.json.pojo;

import meubar.json.pojo.JsonBase;

public class ProdutoJson extends JsonBase {

	private String nome;
	private String categoria;
	private Long categoriaId;
	private String unidade;
	private Long unidadeId;

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

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Long getUnidadeId() {
		return unidadeId;
	}

	public void setUnidadeId(Long unidadeId) {
		this.unidadeId = unidadeId;
	}

}
