package com.jee.mdb;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Иван on 20.02.2017.
 */
@MessageDriven(mappedName = "jms/Topic", name = "MessageConsumer")
public class MessageConsumer implements MessageListener {
    @EJB
    private MessageCache messageCache;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            messageCache.addMessage(textMessage.getText());
            System.out.println("FROM MDB - client type IS " + message.getStringProperty(MessageProducer.CLIENT_TYPE));
            System.out.println("FROM MDB - payload  IS" + textMessage.getText());
        } catch (JMSException ignore) {
        }
    }
}
