package com.jee.integration;

import com.jee.bean.product.ProductBean;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by Иван on 11.03.2017.
 */
public class DecoratorTest extends BaseTestSupport {
    private ProductBean productBean;

    @Override
    public void setUp() throws NamingException {
        super.setUp();

        productBean = (ProductBean) getBean(ProductBean.class);
    }

    @Test
    public void doWork() throws Exception {
        Assert.assertEquals(productBean.getLabel(), "50.0. Dining Table (Discounted)");
    }
}
