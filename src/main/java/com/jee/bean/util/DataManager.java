package com.jee.bean.util;

import com.jee.model.StandardEntity;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Иван on 21.02.2017.
 */
@Stateless(name = "DataManager")
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DataManager {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    public StandardEntity persist(StandardEntity entity) throws Exception {
        em.persist(entity);
        return em.find(entity.getClass(), entity.getId());
    }

    public StandardEntity merge(StandardEntity entity) throws Exception {
        return em.merge(entity);
    }

    public StandardEntity find(StandardEntity entity) {
        return em.find(entity.getClass(), entity.getId());
    }

    public List findAll(Class cls) throws Exception {
        return em.createQuery(String.format("select e from %s e", cls.getName()), cls).getResultList();
    }

    public void delete(StandardEntity entity) throws Exception {
        em.remove(find(entity));
    }
}
