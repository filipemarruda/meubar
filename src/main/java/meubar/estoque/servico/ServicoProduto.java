package meubar.estoque.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.core.model.entity.Unidade;
import meubar.estoque.dao.ProdutoDAO;
import meubar.estoque.json.pojo.ProdutoJson;
import meubar.estoque.model.entity.Categoria;
import meubar.estoque.model.entity.Produto;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoProduto extends ServicoBase<ProdutoDAO, Produto, ProdutoJson> {

	@EJB
	ProdutoDAO itemDao;

	public ProdutoDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected Produto fillUpdatableFields(Produto item, ProdutoJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setCategoria(new Categoria(itemJson.getCategoriaId()));
		item.setUnidade(new Unidade(itemJson.getUnidadeId()));

		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected Produto createItemFromJson(ProdutoJson itemJson) {
		Produto item = new Produto();
		item.setNome(itemJson.getNome());
		item.setCategoria(new Categoria(itemJson.getCategoriaId()));
		item.setUnidade(new Unidade(itemJson.getUnidadeId()));
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected ProdutoJson createItemJson(Produto item) {
		ProdutoJson itemJson = new ProdutoJson();

		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setCategoria(item.getCategoria().getNome());
		itemJson.setCategoriaId(item.getCategoria().getId());
		itemJson.setUnidade(item.getUnidade().getSigla());
		itemJson.setUnidadeId(item.getUnidade().getId());
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
