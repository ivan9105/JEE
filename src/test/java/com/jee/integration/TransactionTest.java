package com.jee.integration;

import com.jee.bean.UserTransactionBean;
import com.jee.model.User;
import junit.framework.Assert;
import org.junit.Test;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.NamingException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Иван on 11.02.2017.
 */
public class TransactionTest extends BaseTestSupport {
    private UserTransactionBean userTransactionBean;
    private Caller transactionalCaller;

    @Override
    public void setUp() throws NamingException {
        super.setUp();

        userTransactionBean = (UserTransactionBean) ejbContainer.getContext().lookup("java:global/classes/UserTransactionBean");
        transactionalCaller = new TransactionBean();
    }

    private void doWork() throws Exception {
        userTransactionBean.addUser(new User("Quentin", "Tarantino", 1));
        userTransactionBean.addUser(new User("Joel", "Coen", 1));
        userTransactionBean.addUser(new User("Joel", "Lebowski", 1));

        List<User> list = userTransactionBean.getUsers();
        Assert.assertEquals("List.size()", 3, list.size());

        for (User user : list) {
            userTransactionBean.deleteUser(user);
        }

        Assert.assertEquals("UserTransactionBean.getUsers()", 3, userTransactionBean.getUsers().size());
    }

    @Test
    public void testWithTransaction() throws Exception{
        transactionalCaller.call(new Callable() {
            public Object call() throws Exception {
                //Todo doestn't work debug it check glassfish settings
                doWork();
                return null;
            }
        });
    }

    @Test
    public void testWithoutTransaction(){
        try {
            doWork();
            Assert.fail("The UserTransactionBean should be using TransactionAttributeType.MANDATORY");
        } catch (javax.ejb.EJBTransactionRequiredException e) {
        } catch (Exception ignore) {
            Assert.fail("Must be throw EJBTransactionRequiredException");
        }
    }

    public static interface Caller {
        public <V> V call(Callable<V> callable) throws Exception;
    }

    @Stateless
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public static class TransactionBean implements Caller {

        public <V> V call(Callable<V> callable) throws Exception {
            return callable.call();
        }
    }
}
