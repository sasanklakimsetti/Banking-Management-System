package com.bms.controller;

import com.bms.model.Account;
import com.bms.model.Customer;
import com.bms.service.CustomerService;
import org.apache.coyote.Response;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/")
    public ResponseEntity<?>addCustomer(@RequestBody Customer customer){
        try {
            customerService.createCustomer(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customer/{custId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long custId){
        Customer customer=customerService.getCustomerByCustomerId(custId);
        if(customer!=null) return new ResponseEntity<>(customer,HttpStatus.FOUND);
        else return new ResponseEntity<>(customer,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update_customer/{customerId}")
    public ResponseEntity<?>updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer){
        Customer customer=customerService.getCustomerByCustomerId(customerId);
        if(customer!=null) {
            customerService.updateCustomer(customerId, updatedCustomer);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        else return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/customer/account_details/{customerId}")
    public ResponseEntity<?> showAccountDetails(@PathVariable Long customerId){
        Account account=customerService.showAccountDetailsByCustomerId(customerId);
        if(account!=null) {
            customerService.showAccountDetailsByCustomerId(customerId);
            return new ResponseEntity<>(account,HttpStatus.OK);
        }
        else return new ResponseEntity<>(account, HttpStatus.NOT_FOUND);
    }
}
