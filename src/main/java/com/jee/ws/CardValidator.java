package com.jee.ws;

import com.jee.ws.model.CreditCard;

import javax.jws.WebService;

/**
 * Created by Иван on 19.02.2017.
 */
@WebService(endpointInterface = "com.jee.ws.Validator")
public class CardValidator implements Validator {
    @Override
    public boolean validate(CreditCard creditCard) {
        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);
        return Integer.parseInt(lastDigit.toString()) % 2 == 0;
    }
}
