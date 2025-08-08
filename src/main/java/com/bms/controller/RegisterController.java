package com.bms.controller;

import com.bms.factory.CustomerFactory;
import com.bms.model.Customer;
import com.bms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    private CustomerFactory customerFactory;

    @Autowired
    private CustomerService customerService;
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/create")
    public ResponseEntity<?> addCustomer(
//            @RequestParam String fname,
//            @RequestParam String lname,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
//            @RequestParam String address,
//            @RequestParam(required = false) String mobile,
//            @RequestParam(required = false) String email,
//            @RequestParam String aadhar,
//            @RequestParam String pan

            @RequestBody Customer customer1
    ) {
//        java.sql.Date sqlDob = new java.sql.Date(dob.getTime());
//        Customer customer = customerFactory.createCustomer(fname, lname, sqlDob, address, mobile, email, aadhar, pan);
//        Customer customer1=customerFactory.createCustomer(customer.getFirstName(), customer.getLastName(), customer.getDob(),customer.getAddress(), customer.getMobile(), customer.getMail(), customer.getAadhar(), customer.getPan());
        customerService.createCustomer(customer1);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }
}
