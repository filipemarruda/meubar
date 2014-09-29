package meubar.cadastro.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.json.pojo.GrupoJson;
import meubar.cadastro.model.dao.GrupoDAO;
import meubar.cadastro.model.entity.Grupo;
import meubar.cadastro.model.entity.Usuario;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoGrupo extends ServicoBase<GrupoDAO, Grupo, GrupoJson> {

	@EJB
	GrupoDAO itemDao;

	public GrupoDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected Grupo fillUpdatableFields(Grupo item, GrupoJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected Grupo createItemFromJson(GrupoJson itemJson) {
		Grupo item = new Grupo(itemJson.getNome());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected GrupoJson createItemJson(Grupo grupo) {
		final GrupoJson grupoJson = new GrupoJson();
		grupoJson.setId(grupo.getId());
		grupoJson.setNome(grupo.getNome());
		grupoJson.setDataCriacao(grupo.getDataCriacao());
		grupoJson.setDataModificacao(grupo.getDataModificacao());
		Usuario usuarioCriacao = getUsuarioDAO().findById(grupo
				.getUsuarioIdCriacao());
		Usuario usuarioModificacao = getUsuarioDAO().findById(grupo
				.getUsuarioIdModificacao());
		grupoJson.setUsuarioCriacao(usuarioCriacao.getNome());
		grupoJson.setUsuarioModificacao(usuarioModificacao.getNome());

		return grupoJson;
	}

}
