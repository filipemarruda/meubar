package meubar.cardapio.json.pojo;

import java.math.BigDecimal;

import meubar.json.pojo.JsonBase;

public class CardapioItemComposicaoJson extends JsonBase {

	private String cardapioSecao;
	private String produto;
	private Long cardapioSecaoId;
	private Long produtoId;
	private Long cardapioItemId;
	private String cardapioItem;
	private BigDecimal quantidade;

	public String getCardapioSecao() {
		return cardapioSecao;
	}

	public void setCardapioSecao(String cardapioSecao) {
		this.cardapioSecao = cardapioSecao;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Long getCardapioSecaoId() {
		return cardapioSecaoId;
	}

	public void setCardapioSecaoId(Long cardapioSecaoId) {
		this.cardapioSecaoId = cardapioSecaoId;
	}
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Long getCardapioItemId() {
		return cardapioItemId;
	}

	public void setCardapioItemId(Long cardapioItemId) {
		this.cardapioItemId = cardapioItemId;
	}

	public String getCardapioItem() {
		return cardapioItem;
	}

	public void setCardapioItem(String cardapioItem) {
		this.cardapioItem = cardapioItem;
	}


}
