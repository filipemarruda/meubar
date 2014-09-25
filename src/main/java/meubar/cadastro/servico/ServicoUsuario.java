package meubar.cadastro.servico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.json.pojo.UsuarioJson;
import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.cadastro.model.entity.Grupo;
import meubar.cadastro.model.entity.Usuario;

import org.apache.commons.lang3.StringUtils;

@Stateless
public class ServicoUsuario {

	@EJB
	private UsuarioDAO usuarioDAO;

	public UsuarioJson getById(String id) {
		long lId = Long.parseLong(id);
		Usuario usuario = usuarioDAO.findById(lId);
		return createUsuarioJson(usuario);
	}

	public List<UsuarioJson> getAll() {
		List<Usuario> results = usuarioDAO.findAll(null);

		List<UsuarioJson> usuarios = new ArrayList<>();
		for (Usuario usuario : results) {
			UsuarioJson usuarioJson = createUsuarioJson(usuario);
			usuarios.add(usuarioJson);
		}
		return usuarios;

	}

	public Usuario cadastrar(UsuarioJson usuarioJson) {

		Usuario usuario = new Usuario(usuarioJson.getLogin(),
				usuarioJson.getSenha());
		usuario.setNome(usuarioJson.getNome());
		usuario.setCpf(usuarioJson.getCpf());
		usuario.setLogin(usuarioJson.getLogin());
		usuario.setSenha(usuarioJson.getSenha());
		usuario.setTelefone(usuarioJson.getTelefone());
		Grupo grupo = new Grupo(usuarioJson.getGrupoId());
		usuario.setGrupo(grupo);
		usuario.setDataCriacao(new Date());
		usuario.setDataModificacao(new Date());
		usuario.setUsuarioIdCriacao(usuarioJson.getUsuarioId());
		usuario.setUsuarioIdModificacao(usuarioJson.getUsuarioId());
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

			usuario.setNome(usuarioJson.getNome());
			usuario.setCpf(usuarioJson.getCpf());
			usuario.setLogin(usuarioJson.getLogin());
			if (!StringUtils.isEmpty(usuarioJson.getSenha())) {
				usuario.setSenha(usuarioJson.getSenha());
			}
			usuario.setTelefone(usuarioJson.getTelefone());
			Grupo grupo = new Grupo(usuarioJson.getGrupoId());
			usuario.setGrupo(grupo);
			usuario.setDataModificacao(new Date());
			usuario.setUsuarioIdModificacao(usuarioJson.getUsuarioId());
			usuarioDAO.save(usuario);
			result = true;

		}

		return result;

	}

	private UsuarioJson createUsuarioJson(Usuario usuario) {
		UsuarioJson usuarioJson = new UsuarioJson();

		usuarioJson.setId(usuario.getId());
		usuarioJson.setLogin(usuario.getLogin());
		usuarioJson.setNome(usuario.getNome());
		usuarioJson.setCpf(usuario.getCpf());
		usuarioJson.setTelefone(usuario.getTelefone());
		usuarioJson.setGrupo(usuario.getGrupo().getNome());
		usuarioJson.setGrupoId(usuario.getGrupo().getId());
		usuarioJson.setDataCriacao(usuario.getDataCriacao());
		usuarioJson.setDataModificacao(usuario.getDataModificacao());
		Usuario usuarioCriacao = usuarioDAO.findById(usuario
				.getUsuarioIdCriacao());
		Usuario usuarioModificacao = usuarioDAO.findById(usuario
				.getUsuarioIdModificacao());
		usuarioJson.setUsuarioCriacao(usuarioCriacao.getNome());
		usuarioJson.setUsuarioModificacao(usuarioModificacao.getNome());

		return usuarioJson;
	}
}
