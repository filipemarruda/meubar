package meubar.core.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.core.dao.EstadoDAO;
import meubar.core.model.entity.Estado;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class EstadoDAOImpl extends MeuBarDAOImpl<Estado, Long> implements
 EstadoDAO {
    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Estado> getEntityClass() {
		return Estado.class;
    }

}
