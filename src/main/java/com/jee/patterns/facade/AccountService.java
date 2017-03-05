package com.jee.patterns.facade;

import javax.ejb.Stateless;

/**
 * Created by Иван on 05.03.2017.
 */
@Stateless
public class AccountService {
    public boolean getLoan(double amount) {
        return true;
    }

    public boolean setCustomerBalannce(long id, double amount) {
        return true;
    }
}
