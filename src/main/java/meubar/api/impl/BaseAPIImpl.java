package meubar.api.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import meubar.acesso.servico.ServicoAcesso;
import meubar.api.BaseAPI;
import meubar.business.util.TokenUtils;
import meubar.cadastro.model.entity.Usuario;

public abstract class BaseAPIImpl implements BaseAPI {

	@EJB
	ServicoAcesso servicoAcesso;

	@Context
	private UriInfo context;

	public Long getUsuarioIdFromToken(String token) {
		String login = TokenUtils.extractUser(token);
		Usuario usuario = servicoAcesso.findByLogin(login);
		return usuario.getId();
	}

	public ServicoAcesso getServicoAcesso() {
		return servicoAcesso;
	}
}
