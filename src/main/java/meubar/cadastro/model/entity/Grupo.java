package meubar.cadastro.model.entity;

import java.util.Date;

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
	@Column(name = "data_criacao")
	private Date dataCriacao;
	@Column(name = "data_modificacao")
	private Date dataModificacao;
	@Column(name = "usuario_id_criacao")
	private Long usuarioIdCriacao;
	@Column(name = "usuario_id_modificacao")
	private Long usuarioIdModificacao;

	public Grupo(Long id) {
		super();
		this.id = id;
	}

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
