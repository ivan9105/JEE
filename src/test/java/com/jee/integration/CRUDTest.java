package com.jee.integration;

import com.jee.bean.UserBean;
import com.jee.model.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by ���� on 07.02.2017.
 */
public class CRUDTest extends BaseTestSupport {
    private UserBean userBean;

    @Before
    public void setUp() throws NamingException {
        super.setUp();
        userBean = (UserBean) ejbContainer.getContext().lookup("java:global/classes/UserBean");
    }

    @Test
    public void dowWork() throws Exception {
        Assert.assertNotNull(userBean);
        User user = new User("Igor", "Kuchmin", 15);
        userBean.add(user);

        User reload = userBean.get(user.getId());
        Assert.assertNotNull(reload);

        reload.setLastName("Stukalov");
        userBean.update(reload);

        reload = userBean.get(reload.getId());
        Assert.assertEquals(reload.getLastName(), "Stukalov");

        userBean.delete(reload.getId());
        reload = userBean.get(reload.getId());
        Assert.assertNull(reload);
    }
}

