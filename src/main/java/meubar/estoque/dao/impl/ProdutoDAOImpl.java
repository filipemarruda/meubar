package meubar.estoque.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.estoque.dao.ProdutoDAO;
import meubar.estoque.model.entity.Produto;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class ProdutoDAOImpl extends MeuBarDAOImpl<Produto, Long> implements ProdutoDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Produto> getEntityClass() {
		return Produto.class;
    }

}
