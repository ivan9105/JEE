package com.jee.integration.portal;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Collections;

/**
 * Created by Иван on 16.02.2017.
 */
public class EchoRestServiceTest extends PortalTestSupport {
    @Test
    public void doWork() throws Exception {
        String get = doGet("http://localhost:8080/JEE/rest/echo");
        Assert.assertEquals("Ping!", get);
        String post = doPost("http://localhost:8080/JEE/rest/echo", Collections.singletonMap("msg", "Ivan"));
        Assert.assertEquals("ECHO: Ivan", post);
    }
}
