package com.bms.controller;

import com.bms.model.Customer;
import com.bms.model.loan.LoanAccount;
import com.bms.repository.loan.LoanAccountRepository;
import com.bms.service.CustomerService;
import com.bms.service.loan.LoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loan_accounts")
public class LoanAccountController {
    @Autowired
    private LoanAccountRepository loanAccountRepository;
    @Autowired
    private LoanAccountService loanAccountService;
    @Autowired
    private CustomerService customerService;
    @PostMapping("/create_loan_account/{customerId}")
    public ResponseEntity<?> createLoanAccount(@PathVariable Long customerId, @RequestBody LoanAccount account){
        Customer customer = customerService.getCustomerByCustomerId(customerId);
        if (customer == null) return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        account.setCustomerId(customer);

        try {
            LoanAccount createdAccount = loanAccountService.openAccount(account);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating loan account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pay_emi/{accountNumber}")
    public ResponseEntity<?>depositToSavings(@PathVariable Long accountNumber, @RequestParam Double amount){
        return loanAccountService.payEmi(accountNumber, amount);
    }
}
