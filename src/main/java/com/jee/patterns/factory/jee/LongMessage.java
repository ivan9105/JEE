package com.jee.patterns.factory.jee;

import javax.enterprise.context.Dependent;

/**
 * Created by Иван on 05.03.2017.
 */
@Message(Message.Type.LONG)
@Dependent
public class LongMessage implements MessageType {
    private String message = "Long message";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
