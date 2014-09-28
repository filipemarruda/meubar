package meubar.acesso.json.pojo;

public class TokenJson {
	private String token;
	private String id;
	private String usuario;
	private String grupo;

	public TokenJson(String token, String id, String usuario, String grupo) {
		super();
		this.token = token;
		this.id = id;
		this.usuario = usuario;
		this.grupo = grupo;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
