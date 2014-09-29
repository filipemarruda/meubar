package meubar.cadastro.model.dao.impl;


import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;

import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.cadastro.model.entity.Usuario;
import meubar.model.dao.impl.MeuBarDAOImpl;


/**
 * Implementação da interface DAO para entidade Login.
 * 
 * @author filipe.mendes
 * 
 */
@Stateless
@Transactional
public class UsuarioDAOImpl extends MeuBarDAOImpl<Usuario, Long> implements
		UsuarioDAO {


    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.azulseguros.model.servicocadastro.dao.LoginDAO#findByLoginAndPassword
     * (java.lang.String, java.lang.String)
     */
    @Override
    public boolean findByLoginAndPassword(String login, String password) {
        final StringBuilder hql = new StringBuilder();
		hql.append("select obj.id from Usuario obj ");
		hql.append("where ");
        hql.append("obj.login = :login and ");
        hql.append("obj.senha = :password ");
        final Query query = getEntityManager().createQuery(hql.toString());
        query.setParameter("login", login);
        query.setParameter("password", password);
        boolean valid = false;
        try {
            valid = query.getSingleResult() != null;
        } catch (Exception e) {
            // do nothing
        }
        return valid;
    }


    /*
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.impl.BaseDAOImpl#getEntityClass()
     */
    @Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
    }

}
