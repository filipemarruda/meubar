package meubar.cardapio.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.cardapio.dao.CardapioItemComposicaoDAO;
import meubar.cardapio.model.entity.CardapioItemComposicao;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class CardapioItemComposicaoDAOImpl extends MeuBarDAOImpl<CardapioItemComposicao, Long> implements
		CardapioItemComposicaoDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<CardapioItemComposicao> getEntityClass() {
		return CardapioItemComposicao.class;
    }

}
