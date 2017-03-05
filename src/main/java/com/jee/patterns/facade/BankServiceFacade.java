package com.jee.patterns.facade;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Иван on 05.03.2017.
 */
@Stateless
public class BankServiceFacade {
    @Inject
    private CustomerService customerService;
    @Inject
    private AccountService accountService;
    @Inject
    private LoanService loanService;

    public boolean getLoan(int sessionId, double amount) {
        long id = customerService.getCustomer(sessionId);
        return customerService.checkId(id)
                && loanService.checkCreditRating(id, amount)
                && accountService.getLoan(amount)
                && accountService.setCustomerBalannce(id, amount);
    }
}
