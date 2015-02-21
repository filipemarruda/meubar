package meubar.cardapio.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import meubar.estoque.model.entity.Produto;
import meubar.model.entity.BaseEntity;

@Entity
@Table(name = "cardapio_item_composicao", schema = "meubar")
public class CardapioItemComposicao implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2851094016926391266L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	private Produto produto;
	@Column(name = "quantidade", length = 7, precision = 2)
	private BigDecimal quantidade;
	@ManyToOne
	@JoinColumn(name = "cardapio_secao_id", referencedColumnName = "id")
	private CardapioSecao cardapioSecao;
	@ManyToOne
	@JoinColumn(name = "cardapio_item_id", referencedColumnName = "id")
	private CardapioItem cardapioItem;
	@Column(name = "data_criacao")
	private Date dataCriacao;
	@Column(name = "data_modificacao")
	private Date dataModificacao;
	@Column(name = "usuario_id_criacao")
	private Long usuarioIdCriacao;
	@Column(name = "usuario_id_modificacao")
	private Long usuarioIdModificacao;

	public CardapioItemComposicao(Long id) {
		super();
		this.id = id;
	}

	public CardapioItemComposicao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CardapioSecao getCardapioSecao() {
		return cardapioSecao;
	}

	public void setCardapioSecao(CardapioSecao cardapioSecao) {
		this.cardapioSecao = cardapioSecao;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public Long getUsuarioIdCriacao() {
		return usuarioIdCriacao;
	}

	public void setUsuarioIdCriacao(Long usuarioIdCriacao) {
		this.usuarioIdCriacao = usuarioIdCriacao;
	}

	public Long getUsuarioIdModificacao() {
		return usuarioIdModificacao;
	}

	public void setUsuarioIdModificacao(Long usuarioIdModificacao) {
		this.usuarioIdModificacao = usuarioIdModificacao;
	}

	public CardapioItem getCardapioItem() {
		return cardapioItem;
	}

	public void setCardapioItem(CardapioItem cardapioItem) {
		this.cardapioItem = cardapioItem;
	}

}
