package com.jee.integration;

import org.junit.After;
import org.junit.Before;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Иван on 11.02.2017.
 */
public class BaseTestSupport {
    protected EJBContainer ejbContainer;

    @After
    public void tearDown() {
        closeContainer();
    }

    @Before
    public void setUp() throws NamingException {
        createContainer();
    }

    protected void createContainer() throws NamingException {
        Map<String, Object> properties = new HashMap<String, Object>();
        //properties.put(EJBContainer.MODULES, new File("build/jar"));
        properties.put(EJBContainer.MODULES, new File("target/JEE"));
        ejbContainer = EJBContainer.createEJBContainer(properties);
    }

    protected void closeContainer() {
        ejbContainer.close();
    }
}
