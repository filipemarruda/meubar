package meubar.core.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.core.dao.UnidadeDAO;
import meubar.core.model.entity.Unidade;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class UnidadeImpl extends MeuBarDAOImpl<Unidade, Long> implements
 UnidadeDAO {
    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Unidade> getEntityClass() {
		return Unidade.class;
    }

}
