package meubar.cadastro.servico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.cadastro.model.entity.Usuario;

@Stateless
public class ServicoCadastro {

	@EJB
	private UsuarioDAO usuarioDAO;

	public boolean acesso(String login, String senha) {

		boolean response = usuarioDAO.findByLoginAndPassword(login, senha);
		return response;

	}

	public boolean atualizaSenha(String login, String novaSenha) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", login);
		List<Usuario> list = usuarioDAO.findAllByParams(params);
		for (Usuario u : list) {
			u.setSenha(novaSenha);
			usuarioDAO.save(u);
			return true;
		}
		return false;
	}

}
