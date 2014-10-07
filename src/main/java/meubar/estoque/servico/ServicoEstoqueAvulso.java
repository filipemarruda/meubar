package meubar.estoque.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.estoque.dao.EstoqueAvulsoDAO;
import meubar.estoque.json.pojo.EstoqueAvulsoJson;
import meubar.estoque.model.entity.EstoqueAvulso;
import meubar.estoque.model.entity.Produto;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoEstoqueAvulso extends ServicoBase<EstoqueAvulsoDAO, EstoqueAvulso, EstoqueAvulsoJson> {

	@EJB
	EstoqueAvulsoDAO itemDao;

	public EstoqueAvulsoDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected EstoqueAvulso fillUpdatableFields(EstoqueAvulso item, EstoqueAvulsoJson itemJson) {
		item.setProduto(new Produto(itemJson.getProdutoId()));
		item.setMotivo(itemJson.getMotivo());
		item.setTipo(itemJson.getTipo());
		item.setQuantidade(itemJson.getQuantidade());
		item.setPreco(itemJson.getPreco());
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected EstoqueAvulso createItemFromJson(EstoqueAvulsoJson itemJson) {
		EstoqueAvulso item = new EstoqueAvulso();
		item.setProduto(new Produto(itemJson.getProdutoId()));
		item.setMotivo(itemJson.getMotivo());
		item.setTipo(itemJson.getTipo());
		item.setQuantidade(itemJson.getQuantidade());
		item.setPreco(itemJson.getPreco());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected EstoqueAvulsoJson createItemJson(EstoqueAvulso item) {
		EstoqueAvulsoJson itemJson = new EstoqueAvulsoJson();

		itemJson.setId(item.getId());
		itemJson.setProduto(item.getProduto().getNome());
		itemJson.setProdutoId(item.getProduto().getId());
		itemJson.setMotivo(item.getMotivo());
		itemJson.setTipo(item.getTipo());
		itemJson.setQuantidade(item.getQuantidade());
		itemJson.setPreco(item.getPreco());
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
