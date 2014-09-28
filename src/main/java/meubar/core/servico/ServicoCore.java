package meubar.core.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.core.dao.EstadoDAO;
import meubar.core.json.pojo.EstadoJson;
import meubar.core.model.entity.Estado;

@Stateless
public class ServicoCore {

	@EJB
	private EstadoDAO estadoDAO;

	public List<EstadoJson> getEstados() {

		List<Estado> results = estadoDAO.findAll(null);

		List<EstadoJson> itens = new ArrayList<>();

		for (Estado item : results) {
			EstadoJson itemJson = createItemJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	private EstadoJson createItemJson(Estado item) {
		final EstadoJson itemJson = new EstadoJson();
		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setUf(item.getUf());

		return itemJson;
	}

}
