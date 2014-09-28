package meubar.json.pojo;

import java.util.Date;

public class JsonBase {

	private Long id;
	private Date dataCriacao;
	private String usuarioCriacao;
	private Date dataModificacao;
	private String usuarioModificacao;
	private Long usuarioId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(String usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public String getUsuarioModificacao() {
		return usuarioModificacao;
	}

	public void setUsuarioModificacao(String usuarioModificacao) {
		this.usuarioModificacao = usuarioModificacao;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}
