package com.jee.ws;

import com.jee.ws.model.CreditCard;

import javax.jws.WebService;

/**
 * Created by Иван on 19.02.2017.
 */
@WebService
public interface Validator {
    boolean validate(CreditCard creditCard);
}
