package meubar.estoque.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.estoque.dao.EstoqueControleDAO;
import meubar.estoque.model.entity.EstoqueControle;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class EstoqueControleDAOImpl extends MeuBarDAOImpl<EstoqueControle, Long> implements EstoqueControleDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<EstoqueControle> getEntityClass() {
		return EstoqueControle.class;
    }

}
