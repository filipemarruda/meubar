package meubar.cadastro.servico;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.json.pojo.UsuarioJson;
import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.cadastro.model.entity.Grupo;
import meubar.cadastro.model.entity.Usuario;

@Stateless
public class ServicoUsuario {

	@EJB
	private UsuarioDAO usuarioDAO;

	public Usuario getById(String id) {
		long lId = Long.parseLong(id);
		return usuarioDAO.findById(lId);
	}

	public List<Usuario> getAll() {

		return usuarioDAO.findAll(null);

	}

	public Usuario cadastrar(UsuarioJson usuarioJson) {

		Usuario usuario = new Usuario(usuarioJson.getLogin(),
				usuarioJson.getSenha());
		long groupId = Long.parseLong(usuarioJson.getGrupo());
		Grupo grupo = new Grupo(groupId);
		usuario.setGrupo(grupo);
		return usuarioDAO.save(usuario);


	}

	public boolean deletar(String id) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Usuario usuario = usuarioDAO.findById(lId);

		if (usuario != null) {
			usuarioDAO.remove(usuario);
			result = true;
		}
		return result;

	}

	public boolean update(String id, UsuarioJson usuarioJson) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Usuario usuario = usuarioDAO.findById(lId);

		if (usuario != null) {

			usuario.setLogin(usuarioJson.getLogin());
			usuario.setSenha(usuarioJson.getSenha());
			long grupoId = Long.parseLong(usuarioJson.getGrupo());
			Grupo grupo = new Grupo(grupoId);
			usuario.setGrupo(grupo);
			usuarioDAO.save(usuario);
			result = true;

		}

		return result;

	}

}
