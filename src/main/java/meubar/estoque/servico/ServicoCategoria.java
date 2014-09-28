package meubar.estoque.servico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.estoque.dao.CategoriaDAO;
import meubar.estoque.json.pojo.CategoriaJson;
import meubar.estoque.model.entity.Categoria;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoCategoria extends ServicoBase {

	@EJB
	private CategoriaDAO categoriaDAO;

	public CategoriaJson getById(String id) {
		long lId = Long.parseLong(id);
		Categoria item = categoriaDAO.findById(lId);
		return createItemJson(item);
	}

	public List<CategoriaJson> getAll() {
		List<Categoria> results = categoriaDAO.findAll(null);

		List<CategoriaJson> itens = new ArrayList<>();
		for (Categoria item : results) {
			CategoriaJson itemJson = createItemJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	public Categoria cadastrar(CategoriaJson itemJson) {

		Categoria item = new Categoria();
		item.setNome(itemJson.getNome());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return categoriaDAO.save(item);


	}

	public boolean deletar(String id) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Categoria item = categoriaDAO.findById(lId);

		if (item != null) {
			categoriaDAO.remove(item);
			result = true;
		}
		return result;

	}

	public boolean update(String id, CategoriaJson itemJson) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Categoria item = categoriaDAO.findById(lId);

		if (item != null) {

			item.setNome(itemJson.getNome());
			item.setDataModificacao(new Date());
			item.setUsuarioIdModificacao(itemJson.getUsuarioId());
			categoriaDAO.save(item);
			result = true;

		}

		return result;

	}

	private CategoriaJson createItemJson(Categoria item) {
		CategoriaJson itemJson = new CategoriaJson();

		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setDataCriacao(item.getDataCriacao());
		itemJson.setDataModificacao(item.getDataModificacao());
		Usuario usuarioCriacao = getUsuarioDAO().findById(item
				.getUsuarioIdCriacao());
		Usuario usuarioModificacao = getUsuarioDAO().findById(item
				.getUsuarioIdModificacao());
		itemJson.setUsuarioCriacao(usuarioCriacao.getNome());
		itemJson.setUsuarioModificacao(usuarioModificacao.getNome());

		return itemJson;
	}
}
