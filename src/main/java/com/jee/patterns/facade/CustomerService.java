package com.jee.patterns.facade;

import javax.ejb.Stateless;

/**
 * Created by Иван on 05.03.2017.
 */
@Stateless
public class CustomerService {
    public long getCustomer(int sessionId) {
        return 1000000l;
    }

    public boolean checkId(long id) {
        return true;
    }
}
