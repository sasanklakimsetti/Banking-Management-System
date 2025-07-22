package com.bms.controller;

import com.bms.model.Customer;
import com.bms.model.loan.LoanAccount;
import com.bms.service.CustomerService;
import com.bms.service.loan.LoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loan_accounts")
public class LoanAccountController {

    @Autowired
    private LoanAccountService loanAccountService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create_loan_account")
    public String createLoanAccount(@ModelAttribute LoanAccount account, @RequestParam Long customerId) {
        Customer customer = customerService.getCustomerByCustomerId(customerId);
        account.setCustomerId(customer);
        loanAccountService.openAccount(account);
        return "redirect:/customer/" + customerId;
    }

    @PostMapping("/pay_emi")
    public String payLoanEmi(@RequestParam Long accountNumber, @RequestParam Double amount) {
        loanAccountService.payEmi(accountNumber, amount);
        return "redirect:/loan/pay-emi/" + accountNumber;
    }
}
