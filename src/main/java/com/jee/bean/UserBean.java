package com.jee.bean;

import com.jee.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Иван on 05.02.2017.
 */
@Stateless
public class UserBean {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    public User add(User user){
        return em.merge(user);
    }

    public User get(long id){
        return em.find(User.class, id);
    }

    public void update(User user){
        add(user);
    }

    public void delete(long id){
        em.remove(get(id));
    }

    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
}
