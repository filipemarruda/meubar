package meubar.cadastro.servico;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.json.pojo.GrupoJson;
import meubar.cadastro.model.dao.GrupoDAO;
import meubar.cadastro.model.entity.Grupo;

@Stateless
public class ServicoGrupo {

	@EJB
	private GrupoDAO grupoDAO;

	public Grupo getById(String id) {
		long lId = Long.parseLong(id);
		return grupoDAO.findById(lId);
	}

	public List<Grupo> getAll() {

		return grupoDAO.findAll(null);

	}

	public Grupo cadastrar(GrupoJson grupoJson) {

		Grupo grupo = new Grupo(grupoJson.getGrupo());
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
			grupo.setGrupo(grupoJson.getGrupo());
			grupoDAO.save(grupo);
			result = true;
		}

		return result;

	}

}
