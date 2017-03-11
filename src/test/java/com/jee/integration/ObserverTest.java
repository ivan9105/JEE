package com.jee.integration;

import com.jee.patterns.observer.EventService;
import com.jee.patterns.observer.TraceObserver;
import junit.framework.Assert;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by Иван on 11.03.2017.
 */
public class ObserverTest extends BaseTestSupport {
    private TraceObserver traceObserver;
    private EventService eventService;

    @Override
    public void setUp() throws NamingException {
        super.setUp();

        traceObserver = (TraceObserver) getBean(TraceObserver.class);
        eventService = (EventService) getBean(EventService.class);
    }

    @Test
    public void doWork() throws Exception {
        eventService.startService();
        Thread.sleep(5000);
        Assert.assertEquals(traceObserver.getParameterMessage(), "Test");
        Assert.assertEquals(traceObserver.getServiceMessage(), "Starting service: Produces message");
    }
}
