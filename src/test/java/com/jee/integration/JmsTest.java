package com.jee.integration;

import com.jee.mdb.MessageCache;
import com.jee.mdb.MessageProducer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by Иван on 21.02.2017.
 */
public class JmsTest extends BaseTestSupport {
    private MessageProducer messageProducer;
    private MessageCache messageCache;

    @Before
    public void setUp() throws NamingException {
        super.setUp();

        messageProducer = (MessageProducer) getBean(MessageProducer.class);
        messageCache = (MessageCache) getBean(MessageCache.class);
    }

    @Test
    public void doWork() throws Exception {
        messageProducer.sendString("Test");
        Thread.sleep(5000);
        Assert.assertEquals(messageCache.getMessages().get(0), "Test");
        messageProducer.sendString("Test2");
        Thread.sleep(5000);
        Assert.assertEquals(messageCache.getMessages().get(1), "Test2");
    }
}
