package meubar.estoque.json.pojo;

import java.math.BigDecimal;

import meubar.json.pojo.JsonBase;

public class EstoqueControleJson extends JsonBase {

	private String produto;
	private Long produtoId;
	private BigDecimal quantidade;
	private String unidade;

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

}
