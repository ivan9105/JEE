package com.jee.bean;

import com.jee.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by ���� on 05.02.2017.
 */
@Stateless(name = "UserBean")
@TransactionManagement(value = TransactionManagementType.BEAN)
public class UserBean {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    public void add(User user) throws Exception {
        try {
            utx.begin();
            em.persist(user);
            utx.commit();
        } catch (Exception ex) {
            utx.rollback();
            throw ex;
        }
    }

    public User get(long id) {
        return em.find(User.class, id);
    }

    public void update(User user) throws Exception {
        try {
            utx.begin();
            em.merge(user);
            utx.commit();
        } catch (Exception ex) {
            utx.rollback();
            throw ex;
        }
    }

    public void delete(long id) throws Exception {
        try {
            utx.begin();
            em.remove(get(id));
            utx.commit();
        } catch (Exception ex) {
            utx.rollback();
            throw ex;
        }
    }

    public List<User> getAll() throws Exception {
        List<User> res;
        try {
            utx.begin();
            TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
            res = namedQuery.getResultList();
            utx.commit();
        } catch (Exception ex) {
            utx.rollback();
            throw ex;
        }
        return res;
    }
}
