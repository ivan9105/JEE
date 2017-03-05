package com.jee.patterns.factory.jee;

import javax.enterprise.context.Dependent;

/**
 * Created by Иван on 05.03.2017.
 */
@Message(Message.Type.SHORT)
@Dependent
public class ShortMessage implements MessageType {
    private String message = "Short message";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
