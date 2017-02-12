package com.jee.bean;

import com.jee.model.User;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ���� on 11.02.2017.
 */
@Stateful
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserTransactionBean {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    public void addUser(User user) throws Exception {
        em.persist(user);
    }

    public void deleteUser(User user) throws Exception {
        em.persist(user);
    }

    public List<User> getUsers() throws Exception {
        return em.createQuery("SELECT u from com.jee.model.User u", User.class).getResultList();
    }
}