package meubar.cardapio.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.cardapio.dao.CardapioSecaoDAO;
import meubar.cardapio.model.entity.CardapioSecao;
import meubar.estoque.model.entity.Categoria;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class CardapioSecaoDAOImpl extends MeuBarDAOImpl<CardapioSecao, Long> implements CardapioSecaoDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<CardapioSecao> getEntityClass() {
		return CardapioSecao.class;
    }

}
