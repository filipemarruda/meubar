package meubar.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import meubar.model.entity.BaseEntity;

@Entity
@Table(name = "unidade", schema = "meubar")
public class Unidade implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2851094016926391266L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "sigla", length = 4)
	private String sigla;
	@Column(name = "nome", length = 20)
	private String nome;

	public Unidade(Long id) {
		super();
		this.id = id;
	}

	public Unidade(String nome, String sigla) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}

	public Unidade() {
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
