package meubar.estoque.dao.impl;


import javax.ejb.Stateless;
import javax.transaction.Transactional;

import meubar.estoque.dao.FornecedorDAO;
import meubar.estoque.model.entity.Fornecedor;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class FornecedorDAOImpl extends MeuBarDAOImpl<Fornecedor, Long> implements FornecedorDAO {


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Fornecedor> getEntityClass() {
		return Fornecedor.class;
    }

}
