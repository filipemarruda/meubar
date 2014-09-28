package meubar.model.entity;


import java.io.Serializable;


/**
 * Interface básica para entidades JPA.
 * 
 * @author filipe.mendes
 * 
 */
public interface BaseEntity<T> extends Serializable {

    /**
     * Retorna o identificador da entidade
     * 
     * @return identificador da entidade
     */
    T getId();


    /**
     * Seta o identificador da entidade
     * 
     * @param id
     *            identificador da entidade
     */
    void setId(T id);
}
