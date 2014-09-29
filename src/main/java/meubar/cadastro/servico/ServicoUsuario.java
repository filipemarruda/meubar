package meubar.cadastro.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.json.pojo.UsuarioJson;
import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.cadastro.model.entity.Grupo;
import meubar.cadastro.model.entity.Usuario;
import meubar.servico.ServicoBase;

import org.apache.commons.lang3.StringUtils;

@Stateless
public class ServicoUsuario extends ServicoBase<UsuarioDAO, Usuario, UsuarioJson> {

	@EJB
	UsuarioDAO itemDao;

	public UsuarioDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected Usuario fillUpdatableFields(Usuario item, UsuarioJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setCpf(itemJson.getCpf());
		item.setLogin(itemJson.getLogin());
		if (!StringUtils.isEmpty(itemJson.getSenha())) {
			item.setSenha(itemJson.getSenha());
		}
		item.setTelefone(itemJson.getTelefone());
		Grupo grupo = new Grupo(itemJson.getGrupoId());
		item.setGrupo(grupo);
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected Usuario createItemFromJson(UsuarioJson itemJson) {
		Usuario item = new Usuario(itemJson.getLogin(), itemJson.getSenha());
		item.setNome(itemJson.getNome());
		item.setCpf(itemJson.getCpf());
		item.setLogin(itemJson.getLogin());
		item.setSenha(itemJson.getSenha());
		item.setTelefone(itemJson.getTelefone());
		Grupo grupo = new Grupo(itemJson.getGrupoId());
		item.setGrupo(grupo);
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected UsuarioJson createItemJson(Usuario usuario) {
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
		Usuario usuarioCriacao = getUsuarioDAO().findById(usuario
				.getUsuarioIdCriacao());
		Usuario usuarioModificacao = getUsuarioDAO().findById(usuario
				.getUsuarioIdModificacao());
		usuarioJson.setUsuarioCriacao(usuarioCriacao.getNome());
		usuarioJson.setUsuarioModificacao(usuarioModificacao.getNome());

		return usuarioJson;
	}
}
