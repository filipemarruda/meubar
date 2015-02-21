package meubar.cardapio.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import meubar.model.entity.BaseEntity;

@Entity
@Table(name = "cardapio_secao", schema = "meubar")
public class CardapioSecao implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2851094016926391266L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome", length = 50)
	private String nome;
	@Column(name = "data_criacao")
	private Date dataCriacao;
	@Column(name = "data_modificacao")
	private Date dataModificacao;
	@Column(name = "usuario_id_criacao")
	private Long usuarioIdCriacao;
	@Column(name = "usuario_id_modificacao")
	private Long usuarioIdModificacao;

	public CardapioSecao(Long id) {
		super();
		this.id = id;
	}

	public CardapioSecao(String nome) {
		super();
		this.nome = nome;
	}

	public CardapioSecao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String grupo) {
		this.nome = grupo;
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

}
