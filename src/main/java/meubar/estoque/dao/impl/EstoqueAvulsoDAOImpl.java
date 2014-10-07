package meubar.estoque.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.estoque.dao.EstoqueAvulsoDAO;
import meubar.estoque.model.entity.EstoqueAvulso;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class EstoqueAvulsoDAOImpl extends MeuBarDAOImpl<EstoqueAvulso, Long> implements EstoqueAvulsoDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<EstoqueAvulso> getEntityClass() {
		return EstoqueAvulso.class;
    }

}
