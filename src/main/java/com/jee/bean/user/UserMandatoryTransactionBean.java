package com.jee.bean.user;

import com.jee.aop.MethodInterceptor;
import com.jee.model.User;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Иван on 11.02.2017.
 */
@Stateless(name = "UserMandatoryTransactionBean")
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserMandatoryTransactionBean {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    @Interceptors(MethodInterceptor.class)
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
