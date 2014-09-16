package meubar.cadastro.model.dao;

import meubar.cadastro.model.entity.Usuario;
import meubar.model.dao.BaseDAO;



/**
 * Interface DAO para entidade Login.
 * 
 * @author geraldo.matos
 * 
 */
public interface UsuarioDAO extends BaseDAO<Usuario, Long> {

    /**
     * Procura um registro pelo login e senha.
     * 
     * @param login
     * @param password
     * @return verdadeiro (true) se encontrar e falso (false) se não
     */
    boolean findByLoginAndPassword(String login, String password);

}
