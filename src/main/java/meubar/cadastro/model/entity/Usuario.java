package meubar.cadastro.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import meubar.model.entity.BaseEntity;

@Entity
@Table(name = "usuario", schema = "meubar")
public class Usuario implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2851094016926391266L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "login", length = 20)
	private String login;
	@Column(name = "senha", length = 255)
	private String senha;
	@Column(name = "nome", length = 255)
	private String nome;
	@Column(name = "cpf", length = 11)
	private String cpf;
	@Column(name = "telefone", length = 15)
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "grupo_id", referencedColumnName = "id")
	private Grupo grupo;

	@Column(name = "data_criacao")
	private Date dataCriacao;
	@Column(name = "data_modificacao")
	private Date dataModificacao;
	@Column(name = "usuario_id_criacao")
	private Long usuarioIdCriacao;
	@Column(name = "usuario_id_modificacao")
	private Long usuarioIdModificacao;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
