package meubar.estoque.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.estoque.dao.CategoriaDAO;
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
public class CategoriaDAOImpl extends MeuBarDAOImpl<Categoria, Long> implements CategoriaDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Categoria> getEntityClass() {
		return Categoria.class;
    }

}
