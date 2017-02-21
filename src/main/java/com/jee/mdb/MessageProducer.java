package com.jee.mdb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 * Created by Иван on 20.02.2017.
 */
@Stateless(name = "MessageProducer")
public class MessageProducer {
    public static final String CLIENT_TYPE = "clientType";

    @Resource(name = "jms/JEE")
    private ConnectionFactory connectionFactory;

    @Resource(name = "jms/Topic")
    private Destination destination;

    public void sendString(String enterString) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            javax.jms.MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setStringProperty(CLIENT_TYPE, "web client");
            message.setText(enterString);
            producer.send(message);
            System.out.println("Message sent");
        } catch (JMSException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (connection != null) connection.close();
        }
    }
}
