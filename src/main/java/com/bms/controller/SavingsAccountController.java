package com.bms.controller;

import com.bms.service.AccountService;
import com.bms.service.CustomerService;
import com.bms.service.savings.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/savings_account")
public class SavingsAccountController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private SavingsAccountService savingsAccountService;
    @Autowired
    private AccountService accountService;

    @PostMapping("/create_account")
    public String createSavingsAccount(@RequestParam Long customerId, @RequestParam String savingsType) {
        savingsAccountService.openSavingsAccount(savingsType, customerId);
        return "redirect:/customer/" + customerId;
    }

    @PostMapping("/deposit")
    public String depositToSavings(@RequestParam Long accountNumber, @RequestParam Double amount) {
        accountService.depositToAccount(accountNumber, amount);
        return "redirect:/savings-actions/" + accountNumber;
    }

    @PostMapping("/withdraw")
    public String withdrawFromSavings(@RequestParam Long accountNumber, @RequestParam Integer amount) {
        savingsAccountService.withdrawFromSavingsAccount(accountNumber, amount);
        return "redirect:/savings-actions/" + accountNumber;
    }
}
