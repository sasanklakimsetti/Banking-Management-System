package com.bms.controller;

import com.bms.factory.CustomerFactory;
import com.bms.model.Account;
import com.bms.model.Customer;
import com.bms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFactory customerFactory;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/create")
    public String addCustomer(
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
            @RequestParam String address,
            @RequestParam(required = false) String mobile,
            @RequestParam(required = false) String email,
            @RequestParam String aadhar,
            @RequestParam String pan
    ) {
        java.sql.Date sqlDob = new java.sql.Date(dob.getTime());
        Customer customer = customerFactory.createCustomer(fname, lname, sqlDob, address, mobile, email, aadhar, pan);
        customerService.createCustomer(customer);
        return "redirect:/customer/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @GetMapping("/all")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/view/{id}")
    public String viewCustomer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerByCustomerId(id));
        return "view-customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerByCustomerId(id));
        return "edit-customer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(
            @PathVariable("id") Long id,
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
            @RequestParam String address,
            @RequestParam(required = false) String mobile,
            @RequestParam(required = false) String email,
            @RequestParam String aadhar,
            @RequestParam String pan
    ) {
        java.sql.Date sqlDob = new java.sql.Date(dob.getTime());
        Customer updated = customerFactory.createCustomer(fname, lname, sqlDob, address, mobile, email, aadhar, pan);
        updated.setCustomerId(id);
        customerService.updateCustomer(id,updated);
        return "redirect:/customer/success";
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.removeCustomer(id);
        return "redirect:/customer/deleted";
    }

    @GetMapping("/deleted")
    public String showDeleteSuccessPage() {
        return "delete-success"; // JSP file name: delete-success.jsp
    }

}
