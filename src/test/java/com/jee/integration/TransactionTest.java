package com.jee.integration;

import com.jee.bean.TransactionCaller;
import com.jee.bean.UserMandatoryTransactionBean;
import com.jee.model.User;
import junit.framework.Assert;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by Иван on 11.02.2017.
 */
public class TransactionTest extends BaseTestSupport {
    private TransactionCaller transactionCaller;
    private UserMandatoryTransactionBean userMandatoryTransactionBean;

    @Override
    public void setUp() throws NamingException {
        super.setUp();

        transactionCaller = (TransactionCaller) ejbContainer.getContext().lookup("java:global/JEE/TransactionCaller");
        userMandatoryTransactionBean = (UserMandatoryTransactionBean)
                ejbContainer.getContext().lookup("java:global/JEE/UserMandatoryTransactionBean");
    }

    @Test
    public void testWithTransaction() throws Exception {
        transactionCaller.call(UserMandatoryTransactionBean.class, "getUsers");
    }

    @Test
    public void testWithoutTransaction() {
        try {
            userMandatoryTransactionBean.addUser(new User("Quentin", "Tarantino", 1));
            Assert.fail("The UserMandatoryTransactionBean should be using TransactionAttributeType.MANDATORY");
        } catch (javax.ejb.EJBTransactionRequiredException e) {
        } catch (Exception ignore) {
            Assert.fail("Must be throw EJBTransactionRequiredException");
        }
    }
}
