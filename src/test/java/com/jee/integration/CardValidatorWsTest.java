package com.jee.integration;

import com.jee.ws.Validator;
import com.jee.ws.model.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Иван on 19.02.2017.
 */
public class CardValidatorWsTest {
    @Test
    public void doWork() throws Exception {
        URL wsdlDocumentLocation = new URL("http://localhost:8080/JEE/CardValidatorService?wsdl");
        String namespaceURI = "http://ws.jee.com/";
        String servicePart = "CardValidatorService";
        String portName = "CardValidatorPort";
        QName serviceQN = new QName(namespaceURI, servicePart);
        QName portQN = new QName(namespaceURI, portName);

        Service service = Service.create(wsdlDocumentLocation, serviceQN);
        Validator cardValidator = service.getPort(portQN, Validator.class);

        CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
        Assert.assertTrue("Credit card should be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("12341233");
        Assert.assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
    }
}
