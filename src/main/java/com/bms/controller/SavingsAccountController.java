package com.bms.controller;

import com.bms.model.Customer;
import com.bms.model.savings.SavingsAccount;
import com.bms.repository.savings.SavingsAccountRepository;
import com.bms.service.CustomerService;
import com.bms.service.savings.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/savings_account")
public class SavingsAccountController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private SavingsAccountService savingsAccountService;
    @ResponseBody
    @PostMapping("/create_account/{customerId}")
    public ResponseEntity<?>createSavingsAccount(@PathVariable Long customerId, @RequestBody SavingsAccount account){
        Customer customer=customerService.getCustomerByCustomerId(customerId);
        if(customer==null) return new ResponseEntity<>("Customer not found",HttpStatus.NOT_FOUND);
        account.setCustomerId(customer);
        savingsAccountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}
