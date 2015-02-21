package meubar.cardapio.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.cardapio.dao.CardapioItemDAO;
import meubar.cardapio.model.entity.CardapioItem;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class CardapioItemDAOImpl extends MeuBarDAOImpl<CardapioItem, Long> implements CardapioItemDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<CardapioItem> getEntityClass() {
		return CardapioItem.class;
    }

}
