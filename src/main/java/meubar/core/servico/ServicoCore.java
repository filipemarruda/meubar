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
import meubar.estoque.dao.EstoqueControleDAO;
import meubar.estoque.json.pojo.EstoqueControleJson;
import meubar.estoque.model.entity.EstoqueControle;

@Stateless
public class ServicoCore {

	@EJB
	private EstadoDAO estadoDAO;
	@EJB
	private UnidadeDAO unidadeDAO;
	@EJB
	private EstoqueControleDAO estoqueDAO;

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

	public List<EstoqueControleJson> getEstoque() {

		List<EstoqueControle> results = estoqueDAO.findAll(null);

		List<EstoqueControleJson> itens = new ArrayList<>();

		for (EstoqueControle item : results) {
			EstoqueControleJson itemJson = createEstoqueControleJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	private EstoqueControleJson createEstoqueControleJson(EstoqueControle item) {
		final EstoqueControleJson itemJson = new EstoqueControleJson();
		itemJson.setId(item.getId());
		itemJson.setProdutoId(item.getProduto().getId());
		itemJson.setProduto(item.getProduto().getNome());
		itemJson.setUnidade(item.getProduto().getUnidade().getSigla());
		itemJson.setQuantidade(item.getQuantidade());
		return itemJson;
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
