package meubar.model.dao.impl;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import meubar.model.dao.BaseDAO;
import meubar.model.entity.BaseEntity;


/**
 * Implementação da interface BaseDAO.
 * 
 * @author filipe.mendes
 * 
 * @param <T>
 * @param <K>
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class MeuBarDAOImpl<T extends BaseEntity<K>, K> implements BaseDAO<T, K> {

	@PersistenceContext(unitName = "meubarpgsql")
    private EntityManager entityManager;


    /**
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.BaseDAO#remove(br.com.azulseguros.model.entity.BaseEntity)
     */
    public void remove(T entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }


    /**
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.BaseDAO#save(br.com.azulseguros.model.entity.BaseEntity)
     */
    public T save(T entity) {
        final T newEntity = entityManager.merge(entity);
        entityManager.flush();
        return newEntity;
    }


    /**
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.BaseDAO#findById(java.lang.Long)
     */
    public T findById(K id) {
        return (T) entityManager.find(getEntityClass(), id);
    }


    /**
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.BaseDAO#findAll(br.com.azulseguros.model.entity.BaseEntity)
     */
	public List<T> findAll(T entity) {
        final Query query = entityManager.createQuery("from " + getEntityName() + " obj");
        return query.getResultList();
    }


    /**
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.BaseDAO#findByParams(java.util.Map)
     */
    public T findByParams(final Map<String, Object> params) {
        T entity = null;
        if (params != null && !params.isEmpty()) {
            final StringBuilder hql = new StringBuilder("from " + getEntityName() + " obj ");
            hql.append(" where ");
            int count = 0;
            for (final String key : params.keySet()) {
                if (count > 0) {
                    hql.append(" and ");
                }
                hql.append("obj." + key + " = :" + key);
                ++count;
            }
            final Query query = entityManager.createQuery(hql.toString());
            query.setMaxResults(1);
            for (final String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
            try {
                entity = (T) query.getSingleResult();
            } catch (Exception e) {
                // do nothing
            }
        }
        return entity;
    }


    /**
     * (non-Javadoc)
     * 
     * @see br.com.azulseguros.model.dao.BaseDAO#findAllByParams(java.util.Map)
     */
    public List<T> findAllByParams(final Map<String, Object> params) {
        List<T> entities = null;
        if (params != null && !params.isEmpty()) {
            final StringBuilder hql = new StringBuilder("from " + getEntityName() + " obj ");
            hql.append(" where ");
            int count = 0;
            for (final String key : params.keySet()) {
                if (count > 0) {
                    hql.append(" and ");
                }
                hql.append("obj." + key + " = :" + key);
                ++count;
            }
            final Query query = entityManager.createQuery(hql.toString());
            for (final String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
            try {
                entities = query.getResultList();
            } catch (Exception e) {
                // do nothing
            }
        }
        return entities;
    }


    /**
	 * (non-Javadoc)
	 * 
	 * @see br.com.azulseguros.model.dao.BaseDAO#findAllByParams(java.util.Map)
	 */
	public T findOneByParams(final Map<String, Object> params) {
		T entity = null;
		if (params != null && !params.isEmpty()) {
			final StringBuilder hql = new StringBuilder("from "
					+ getEntityName() + " obj ");
			hql.append(" where ");
			int count = 0;
			for (final String key : params.keySet()) {
				if (count > 0) {
					hql.append(" and ");
				}
				hql.append("obj." + key + " = :" + key);
				++count;
			}
			final Query query = entityManager.createQuery(hql.toString())
					.setMaxResults(1);
			for (final String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
			try {
				List results = query.getResultList();
				if (results.size() > 0) {
					entity = (T) query.getResultList().get(0);
				}
			} catch (Exception e) {
				// do nothing
			}
		}
		return entity;
	}

	/**
	 * Retorna o nome da entidade atual.
	 * 
	 * @return
	 */
    private String getEntityName() {
        return getEntityClass().getSimpleName();
    }


    /**
     * Retorna a classe da entidade atual.
     * 
     * @return
     */
    public abstract Class<T> getEntityClass();


    /**
     * Retorna o Entity Manager atual.
     * 
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
