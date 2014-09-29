package meubar.estoque.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.estoque.dao.CategoriaDAO;
import meubar.estoque.json.pojo.CategoriaJson;
import meubar.estoque.model.entity.Categoria;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoCategoria extends ServicoBase<CategoriaDAO, Categoria, CategoriaJson> {

	@EJB
	CategoriaDAO itemDao;

	public CategoriaDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected Categoria fillUpdatableFields(Categoria item, CategoriaJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected Categoria createItemFromJson(CategoriaJson itemJson) {
		Categoria item = new Categoria();
		item.setNome(itemJson.getNome());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CategoriaJson createItemJson(Categoria item) {
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
