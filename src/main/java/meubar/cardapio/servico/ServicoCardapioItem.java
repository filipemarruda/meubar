package meubar.cardapio.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.cardapio.dao.CardapioItemDAO;
import meubar.cardapio.json.pojo.CardapioItemJson;
import meubar.cardapio.model.entity.CardapioItem;
import meubar.cardapio.model.entity.CardapioSecao;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoCardapioItem extends ServicoBase<CardapioItemDAO, CardapioItem, CardapioItemJson> {

	@EJB
	CardapioItemDAO itemDao;

	public CardapioItemDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected CardapioItem fillUpdatableFields(CardapioItem item, CardapioItemJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setPreco(itemJson.getPreco());
		item.setCardapioSecao(new CardapioSecao(itemJson.getCardapioSecaoId()));
		item.setNumero(item.getNumero());
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CardapioItem createItemFromJson(CardapioItemJson itemJson) {
		CardapioItem item = new CardapioItem();
		item.setNome(itemJson.getNome());
		item.setPreco(itemJson.getPreco());
		item.setCardapioSecao(new CardapioSecao(itemJson.getCardapioSecaoId()));
		item.setNumero(itemJson.getNumero());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CardapioItemJson createItemJson(CardapioItem item) {
		CardapioItemJson itemJson = new CardapioItemJson();

		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setPreco(item.getPreco());
		itemJson.setCardapioSecao(item.getCardapioSecao().getNome());
		itemJson.setCardapioSecaoId(item.getCardapioSecao().getId());
		itemJson.setNumero(item.getNumero());
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
