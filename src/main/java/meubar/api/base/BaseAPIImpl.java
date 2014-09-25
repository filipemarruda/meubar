package meubar.api.base;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import meubar.business.TokenUtils;
import meubar.cadastro.model.entity.Usuario;
import meubar.cadastro.servico.ServicoCadastro;

public abstract class BaseAPIImpl implements BaseAPI {

	@EJB
	ServicoCadastro servicoCadastro;

	@Context
	private UriInfo context;

	public Long getUsuarioIdFromToken(String token) {
		String login = TokenUtils.extractUser(token);
		Usuario usuario = servicoCadastro.findByLogin(login);
		return usuario.getId();
	}

	public ServicoCadastro getServicoCadastro() {
		return servicoCadastro;
	}
}
