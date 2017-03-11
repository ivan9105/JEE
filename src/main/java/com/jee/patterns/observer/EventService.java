package com.jee.patterns.observer;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by Иван on 11.03.2017.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventService {
    private String message = "Produces message";

    @Inject @MessageEvent(MessageEvent.Type.SERVICE)
    private Event<String> serviceEvent;

    @Inject @MessageEvent(MessageEvent.Type.PARAMETER)
    private Event<String> parameterEvent;

    public void startService() {
        serviceEvent.fire("Starting service: " + message);
        parameterEvent.fire("Test");
    }
}
