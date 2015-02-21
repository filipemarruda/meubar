package meubar.cardapio.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.cardapio.dao.CardapioItemComposicaoDAO;
import meubar.cardapio.json.pojo.CardapioItemComposicaoJson;
import meubar.cardapio.model.entity.CardapioItem;
import meubar.cardapio.model.entity.CardapioItemComposicao;
import meubar.cardapio.model.entity.CardapioSecao;
import meubar.estoque.model.entity.Produto;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoCardapioItemComposicao extends
		ServicoBase<CardapioItemComposicaoDAO, CardapioItemComposicao, CardapioItemComposicaoJson> {

	@EJB
	CardapioItemComposicaoDAO itemDao;

	public CardapioItemComposicaoDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected CardapioItemComposicao fillUpdatableFields(CardapioItemComposicao item,
			CardapioItemComposicaoJson itemJson) {
		item.setProduto(new Produto(itemJson.getProdutoId()));
		item.setQuantidade(itemJson.getQuantidade());
		item.setCardapioSecao(new CardapioSecao(itemJson.getCardapioSecaoId()));
		item.setCardapioItem(new CardapioItem(itemJson.getCardapioItemId()));
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CardapioItemComposicao createItemFromJson(CardapioItemComposicaoJson itemJson) {
		CardapioItemComposicao item = new CardapioItemComposicao();
		item.setProduto(new Produto(itemJson.getProdutoId()));
		item.setQuantidade(itemJson.getQuantidade());
		item.setCardapioSecao(new CardapioSecao(itemJson.getCardapioSecaoId()));
		item.setCardapioItem(new CardapioItem(itemJson.getCardapioItemId()));
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CardapioItemComposicaoJson createItemJson(CardapioItemComposicao item) {
		CardapioItemComposicaoJson itemJson = new CardapioItemComposicaoJson();

		itemJson.setId(item.getId());
		itemJson.setProduto(item.getProduto().getNome());
		itemJson.setProdutoId(item.getProduto().getId());
		itemJson.setQuantidade(item.getQuantidade());
		itemJson.setCardapioSecao(item.getCardapioSecao().getNome());
		itemJson.setCardapioSecaoId(item.getCardapioSecao().getId());
		itemJson.setCardapioItem(item.getCardapioItem().getNome());
		itemJson.setCardapioItemId(item.getCardapioItem().getId());
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
