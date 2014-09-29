package meubar.estoque.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.estoque.dao.EstoqueEntradaDAO;
import meubar.estoque.model.entity.EstoqueEntrada;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class EstoqueEntradaDAOImpl extends MeuBarDAOImpl<EstoqueEntrada, Long> implements EstoqueEntradaDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<EstoqueEntrada> getEntityClass() {
		return EstoqueEntrada.class;
    }

}
