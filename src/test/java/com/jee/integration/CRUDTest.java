package com.jee.integration;

import com.jee.bean.UserBean;
import com.jee.model.User;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Иван on 07.02.2017.
 */
public class CRUDTest {
    private static EJBContainer ejbContainer;

    private static UserBean userBean;

    @After
    public void tearDown() {
        ejbContainer.close();
    }

    @Before
    public void setUp() throws NamingException {
        Map<String, Object> properties = new HashMap<String, Object>();
        //properties.put(EJBContainer.MODULES, new File("build/jar"));
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        ejbContainer = EJBContainer.createEJBContainer(properties);
        userBean = (UserBean) ejbContainer.getContext().lookup("java:global/classes/UserBean");
    }

    @Test
    public void dowWork() throws Exception {
        Assert.assertNotNull(userBean);
        User user = new User();
        user.setAge(15);
        user.setName("Igor");
        user.setLastName("Kuchmin");
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

