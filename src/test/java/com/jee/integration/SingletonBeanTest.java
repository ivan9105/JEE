package com.jee.integration;

import com.jee.bean.util.ComponentRegistry;
import com.jee.bean.util.PropertyRegistry;
import junit.framework.Assert;
import org.junit.Test;

import javax.naming.Context;
import java.net.URI;
import java.util.Collection;
import java.util.Date;

/**
 * Created by ���� on 13.02.2017.
 */
public class SingletonBeanTest extends BaseTestSupport {
    @Test
    public void singletonOneTest() throws Exception {
        Context context = ejbContainer.getContext();
        ComponentRegistry one = (ComponentRegistry) context.lookup("java:global/JEE/ComponentRegistry");
        ComponentRegistry two = (ComponentRegistry) context.lookup("java:global/JEE/ComponentRegistry");

        URI expectedUri = new URI("foo://bar/baz");
        one.setComponent(URI.class, expectedUri);
        URI actualUri = two.getComponent(URI.class);
        Assert.assertSame(expectedUri, actualUri);

        two.removeComponent(URI.class);
        URI uri = one.getComponent(URI.class);
        Assert.assertNull(uri);

        one.removeComponent(URI.class);
        uri = two.getComponent(URI.class);
        Assert.assertNull(uri);

        Date expectedDate = new Date();
        two.setComponent(Date.class, expectedDate);
        Date actualDate = one.getComponent(Date.class);
        Assert.assertSame(expectedDate, actualDate);

        Collection<?> collection = one.getComponents();
        System.out.println(collection);
        Assert.assertEquals("Reference 'one' - ComponentRegistry contains one record", collection.size(), 1);

        collection = two.getComponents();
        Assert.assertEquals("Reference 'two' - ComponentRegistry contains one record", collection.size(), 1);
    }

    @Test
    public void singletonTwoTest() throws Exception {
        Context context = ejbContainer.getContext();

        PropertyRegistry one = (PropertyRegistry) context.lookup("java:global/JEE/PropertyRegistry");
        PropertyRegistry two = (PropertyRegistry) context.lookup("java:global/JEE/PropertyRegistry");

        one.setProperty("url", "http://superbiz.org");
        String url = two.getProperty("url");
        Assert.assertSame("http://superbiz.org", url);

        two.removeProperty("url");
        url = one.getProperty("url");
        Assert.assertNull(url);

        two.setProperty("version", "1.0.5");
        String version = one.getProperty("version");
        Assert.assertSame("1.0.5", version);

        one.removeProperty("version");
        version = two.getProperty("version");
        Assert.assertNull(version);
    }
}