package com.jee.bean.user;

import com.jee.aop.ConstructorInterceptor;
import com.jee.aop.MethodInterceptor;
import com.jee.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by ���� on 05.02.2017.
 */
@Interceptors(ConstructorInterceptor.class)
@Stateless(name = "UserBean")
@TransactionManagement(value = TransactionManagementType.BEAN)
public class UserBean {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    @Interceptors(MethodInterceptor.class)
    public User add(User user) throws Exception {
        User res;
        try {
            utx.begin();
            em.persist(user);
            res = em.find(User.class, user.getId());
            utx.commit();
        } catch (Exception ex) {
            utx.rollback();
            throw ex;
        }
        return res;
    }

    @Interceptors(MethodInterceptor.class)
    public User get(long id) {
        return em.find(User.class, id);
    }

    @Interceptors(MethodInterceptor.class)
    public User update(User user) throws Exception {
        User res;
        try {
            utx.begin();
            res = em.merge(user);
            utx.commit();
        } catch (Exception ex) {
            utx.rollback();
            throw ex;
        }
        return res;
    }

    @Interceptors(MethodInterceptor.class)
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

    @Interceptors(MethodInterceptor.class)
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
