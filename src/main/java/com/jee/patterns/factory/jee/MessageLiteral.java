package com.jee.patterns.factory.jee;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by ���� on 05.03.2017.
 */
public class MessageLiteral extends AnnotationLiteral<Message> implements Message {
    private Type type;

    public MessageLiteral(Type type) {
        this.type = type;
    }

    @Override
    public Type value() {
        return type;
    }
}
