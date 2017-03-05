package com.jee.integration;

import com.jee.patterns.factory.jee.*;
import junit.framework.Assert;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by Иван on 05.03.2017.
 */
public class FactoryTest extends BaseTestSupport{
    private MessageFactory factory;

    @Override
    public void setUp() throws NamingException {
        super.setUp();

        factory = (MessageFactory) getBean(MessageFactory.class);
    }

    @Test
    public void doWork() throws Exception {
        MessageType longMessage = factory.getMessage(Message.Type.LONG);
        MessageType shortMessage = factory.getMessage(Message.Type.SHORT);

        Assert.assertTrue(longMessage instanceof LongMessage);
        Assert.assertTrue(shortMessage instanceof ShortMessage);
    }
}
