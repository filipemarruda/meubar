package meubar.servico;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.dao.UsuarioDAO;

@Stateless
public abstract class ServicoBase {

	@EJB
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
