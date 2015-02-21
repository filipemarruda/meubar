package meubar.cardapio.json.pojo;

import java.math.BigDecimal;

import meubar.json.pojo.JsonBase;

public class CardapioItemJson extends JsonBase {

	private String nome;
	private BigDecimal preco;
	private String cardapioSecao;
	private Long cardapioSecaoId;
	private Integer numero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getCardapioSecaoId() {
		return cardapioSecaoId;
	}

	public void setCardapioSecaoId(Long cardapioSecaoId) {
		this.cardapioSecaoId = cardapioSecaoId;
	}

	public String getCardapioSecao() {
		return cardapioSecao;
	}

	public void setCardapioSecao(String cardapioSecao) {
		this.cardapioSecao = cardapioSecao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
