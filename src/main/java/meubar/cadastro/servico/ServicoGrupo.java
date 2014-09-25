package meubar.cadastro.servico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.json.pojo.GrupoJson;
import meubar.cadastro.model.dao.GrupoDAO;
import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.cadastro.model.entity.Grupo;
import meubar.cadastro.model.entity.Usuario;

@Stateless
public class ServicoGrupo {

	@EJB
	private GrupoDAO grupoDAO;

	@EJB
	private UsuarioDAO usuarioDAO;

	public GrupoJson getById(String id) {
		long lId = Long.parseLong(id);
		GrupoJson grupoJson = createGrupoJson(grupoDAO.findById(lId));
		return grupoJson;
	}

	public List<GrupoJson> getAll() {

		List<Grupo> results = grupoDAO.findAll(null);

		List<GrupoJson> grupos = new ArrayList<>();

		for (Grupo grupo : results) {
			GrupoJson grupoJson = createGrupoJson(grupo);
			grupos.add(grupoJson);
		}
		return grupos;

	}


	public Grupo cadastrar(GrupoJson grupoJson) {

		Grupo grupo = new Grupo(grupoJson.getNome());
		grupo.setDataCriacao(new Date());
		grupo.setDataModificacao(new Date());
		grupo.setUsuarioIdCriacao(grupoJson.getUsuarioId());
		grupo.setUsuarioIdModificacao(grupoJson.getUsuarioId());
		return grupoDAO.save(grupo);

	}

	public boolean deletar(String id) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Grupo grupo = grupoDAO.findById(lId);

		if (grupo != null) {
			grupoDAO.remove(grupo);
			result = true;
		}
		return result;

	}

	public boolean update(String id, GrupoJson grupoJson) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Grupo grupo = grupoDAO.findById(lId);

		if (grupo != null) {
			grupo.setNome(grupoJson.getNome());
			grupo.setDataModificacao(new Date());
			grupo.setUsuarioIdModificacao(grupoJson.getUsuarioId());
			grupoDAO.save(grupo);
			result = true;
		}

		return result;

	}

	private GrupoJson createGrupoJson(Grupo grupo) {
		final GrupoJson grupoJson = new GrupoJson();
		grupoJson.setId(grupo.getId());
		grupoJson.setNome(grupo.getNome());
		grupoJson.setDataCriacao(grupo.getDataCriacao());
		grupoJson.setDataModificacao(grupo.getDataModificacao());
		Usuario usuarioCriacao = usuarioDAO.findById(grupo
				.getUsuarioIdCriacao());
		Usuario usuarioModificacao = usuarioDAO.findById(grupo
				.getUsuarioIdModificacao());
		grupoJson.setUsuarioCriacao(usuarioCriacao.getNome());
		grupoJson.setUsuarioModificacao(usuarioModificacao.getNome());

		return grupoJson;
	}

}
