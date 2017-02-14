package com.jee.bean.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Properties;

/**
 * Created by Иван on 13.02.2017.
 */

@Singleton(name = "PropertyRegistry")
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class PropertyRegistry {
    private final Properties properties = new Properties();

    @PostConstruct
    public void applicationStartup() {
        properties.putAll(System.getProperties());
    }

    @PreDestroy
    public void applicationShutdown() {
        properties.clear();
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

    public String setProperty(final String key, final String value) {
        return (String) properties.setProperty(key, value);
    }

    public String removeProperty(final String key) {
        return (String) properties.remove(key);
    }
}
