package com.jee.patterns.observer;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 * Created by Иван on 11.03.2017.
 */
@Stateless
public class TraceObserver {
    private String serviceMessage;
    private String parameterMessage;

    public void serviceTrace(@Observes @MessageEvent(MessageEvent.Type.SERVICE) String message) {
        this.serviceMessage = message;
    }

    public void parameterTrace(@Observes @MessageEvent(MessageEvent.Type.PARAMETER) String message) {
        this.parameterMessage = message;
    }

    public void onSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS)
                          @MessageEvent(MessageEvent.Type.PARAMETER) String message) {
        System.out.println("After success: " + message);
    }

    public String getServiceMessage() {
        return serviceMessage;
    }

    public void setServiceMessage(String serviceMessage) {
        this.serviceMessage = serviceMessage;
    }

    public String getParameterMessage() {
        return parameterMessage;
    }

    public void setParameterMessage(String parameterMessage) {
        this.parameterMessage = parameterMessage;
    }
}

