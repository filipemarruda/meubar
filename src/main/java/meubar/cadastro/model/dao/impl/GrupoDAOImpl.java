package meubar.cadastro.model.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.cadastro.model.dao.GrupoDAO;
import meubar.cadastro.model.entity.Grupo;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author geraldo.matos
 * 
 */
@Stateless
@Transactional
public class GrupoDAOImpl extends MeuBarDAOImpl<Grupo, Long> implements
		GrupoDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Grupo> getEntityClass() {
		return Grupo.class;
    }

}
