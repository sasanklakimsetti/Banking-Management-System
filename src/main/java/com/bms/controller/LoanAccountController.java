package com.bms.controller;

import com.bms.model.Customer;
import com.bms.model.loan.LoanAccount;
import com.bms.service.CustomerService;
import com.bms.service.loan.LoanAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/loan_account")
public class LoanAccountController {

    @Autowired
    private LoanAccountService loanAccountService;

    @Autowired
    private CustomerService customerService;

    // Show loan creation form
    @GetMapping("/create")
    public String showCreateLoanForm(@RequestParam Long customerId, Model model) {
        model.addAttribute("customerId", customerId);
        return "loan/createLoanAccount";
    }

    // Handle loan creation
    @PostMapping("/create_account")
    public String createLoanAccount(@ModelAttribute LoanAccount account, @RequestParam Long customerId) {
        try {
            Customer customer = customerService.getCustomerByCustomerId(customerId);
            if (customer == null) {
                throw new IllegalArgumentException("Customer not found with ID: " + customerId);
            }
            account.setCustomerId(customer);
            loanAccountService.openAccount(account);
            return "redirect:/customer/" + customerId; // or a success page
        } catch (Exception e) {
            e.printStackTrace(); // ✅ Add this to log the issue
            return "error";       // Make sure error.jsp exists and shows a useful message
        }
    }



    // Show EMI payment form
    @GetMapping("/pay_emi")
    public String showPayEmiForm(@RequestParam Long accountNumber, Model model) {
        model.addAttribute("accountNumber", accountNumber);
        return "loan/payEmiForm";
    }

    // Handle EMI payment
    @PostMapping("/pay_emi")
    public String payLoanEmi(@RequestParam Long accountNumber, @RequestParam Double amount, Model model) {
        ResponseEntity<?> response = loanAccountService.payEmi(accountNumber, amount);

        if (response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("message", response.getBody());
            return "loan/emiSuccess";
        }

        model.addAttribute("error", response.getBody());
        return "error";
    }

    // Success view for EMI
    @GetMapping("/pay_emi_success")
    public String showEmiSuccessPage() {
        return "loan/emiSuccess";
    }
}
