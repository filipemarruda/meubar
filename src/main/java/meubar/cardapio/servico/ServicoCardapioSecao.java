package meubar.cardapio.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.cardapio.dao.CardapioSecaoDAO;
import meubar.cardapio.json.pojo.CardapioSecaoJson;
import meubar.cardapio.model.entity.CardapioSecao;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoCardapioSecao extends ServicoBase<CardapioSecaoDAO, CardapioSecao, CardapioSecaoJson> {

	@EJB
	CardapioSecaoDAO itemDao;

	public CardapioSecaoDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected CardapioSecao fillUpdatableFields(CardapioSecao item, CardapioSecaoJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CardapioSecao createItemFromJson(CardapioSecaoJson itemJson) {
		CardapioSecao item = new CardapioSecao();
		item.setNome(itemJson.getNome());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected CardapioSecaoJson createItemJson(CardapioSecao item) {
		CardapioSecaoJson itemJson = new CardapioSecaoJson();

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
