package meubar.core.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.core.dao.EstadoDAO;
import meubar.core.dao.UnidadeDAO;
import meubar.core.json.pojo.EstadoJson;
import meubar.core.json.pojo.UnidadeJson;
import meubar.core.model.entity.Estado;
import meubar.core.model.entity.Unidade;

@Stateless
public class ServicoCore {

	@EJB
	private EstadoDAO estadoDAO;
	@EJB
	private UnidadeDAO unidadeDAO;

	public List<EstadoJson> getEstados() {

		List<Estado> results = estadoDAO.findAll(null);

		List<EstadoJson> itens = new ArrayList<>();

		for (Estado item : results) {
			EstadoJson itemJson = createEstadosJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	public List<UnidadeJson> getUnidades() {

		List<Unidade> results = unidadeDAO.findAll(null);

		List<UnidadeJson> itens = new ArrayList<>();

		for (Unidade item : results) {
			UnidadeJson itemJson = createUnidadeJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	private EstadoJson createEstadosJson(Estado item) {
		final EstadoJson itemJson = new EstadoJson();
		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setUf(item.getUf());

		return itemJson;
	}

	private UnidadeJson createUnidadeJson(Unidade item) {
		final UnidadeJson itemJson = new UnidadeJson();
		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setSigla(item.getSigla());

		return itemJson;
	}

}
