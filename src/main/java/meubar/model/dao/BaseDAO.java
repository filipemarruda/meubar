package meubar.model.dao;


import java.util.List;
import java.util.Map;

import meubar.model.entity.BaseEntity;


/**
 * Interface com definição de métodos básicos para DAOs.
 * 
 * @author geraldo.matos
 * 
 * @param <T>
 */
public interface BaseDAO<T extends BaseEntity<K>, K> {

    /**
     * Remove um registro do banco de dados.
     * 
     * @param entity
     */
    void remove(T entity);


    /**
     * Salva um registro no banco de dados.
     * 
     * @param entity
     * @return
     */
    T save(T entity);


    /**
     * Procura um registro pelo seu identificador.
     * 
     * @param id
     * @return
     */
    T findById(K id);


    /**
	 * Procura todos os registros baseados na entidade passada como parâmetro.
	 * 
	 * @param entity
	 * @return
	 */
	List<T> findAll(T entity);


    /**
	 * Procura um registro específico de acordo com o mapa de parametros.
	 * 
	 * @param params
	 * @return
	 */
    T findByParams(final Map<String, Object> params);


    /**
     * Procura todos os registros de acordo com o mapa de parametros.
     * 
     * @param params
     * @return
     */
    List<T> findAllByParams(final Map<String, Object> params);

}
