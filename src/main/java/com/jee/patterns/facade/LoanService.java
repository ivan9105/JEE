package com.jee.patterns.facade;

import javax.ejb.Stateless;

/**
 * Created by Иван on 05.03.2017.
 */
@Stateless
public class LoanService {
    public boolean checkCreditRating(long id, double amount) {
        return true;
    }
}
