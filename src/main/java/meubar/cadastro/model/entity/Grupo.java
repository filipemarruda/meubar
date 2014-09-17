package meubar.cadastro.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import meubar.model.entity.BaseEntity;

@Entity
@Table(name = "grupo", schema = "meubar")
public class Grupo implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2851094016926391266L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "grupo", length = 20)
	private String grupo;

	public Grupo(String grupo) {
		super();
		this.grupo = grupo;
	}

	public Grupo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}
