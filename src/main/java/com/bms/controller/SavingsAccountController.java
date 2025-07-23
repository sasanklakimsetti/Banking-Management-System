package com.bms.controller;

import com.bms.model.savings.SavingsAccount;
import com.bms.service.savings.SavingsAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/savings_account")
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;

    // Show savings account creation form
    @GetMapping("/create_account")
    public String showCreateForm(@RequestParam Long customerId, Model model) {
        model.addAttribute("customerId", customerId);
        return "savings/createSavingsAccount";
    }

    // Handle account creation
    @PostMapping("/create_account")
    public String createSavingsAccount(@RequestParam Long customerId, @RequestParam String savingsType, Model model) {
        try {
            SavingsAccount created = savingsAccountService.openSavingsAccount(savingsType, customerId);
            model.addAttribute("accountNumber", created.getAccountNumber());
            model.addAttribute("balance", created.getBalance());
            model.addAttribute("savingsType", created.getSavingsType());
            return "savings/savingsCreated";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    // Show deposit form
    @GetMapping("/deposit")
    public String showDepositForm(@RequestParam Long accountNumber, Model model) {
        model.addAttribute("accountNumber", accountNumber);
        return "savings/depositSavings";
    }

    // Handle deposit
    @PostMapping("/deposit")
    public String depositToSavings(@RequestParam Long accountNumber, @RequestParam Integer amount, Model model) {
        ResponseEntity<?> response = savingsAccountService.depositToSavingsAccount(accountNumber, amount);

        if (response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("message", response.getBody());
            return "savings/depositSuccess";
        }

        model.addAttribute("error", response.getBody());
        return "error";
    }

    // Show withdraw form
    @GetMapping("/withdraw")
    public String showWithdrawForm(@RequestParam Long accountNumber, Model model) {
        model.addAttribute("accountNumber", accountNumber);
        return "savings/withdrawSavings";
    }

    // Handle withdrawal
    @PostMapping("/withdraw")
    public String withdrawFromSavings(@RequestParam Long accountNumber, @RequestParam Integer amount, Model model) {
        ResponseEntity<?> response = savingsAccountService.withdrawFromSavingsAccount(accountNumber, amount);

        if (response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("message", response.getBody());
            return "savings/withdrawSuccess";
        }

        model.addAttribute("error", response.getBody());
        return "error";
    }

    // Show deposit success
    @GetMapping("/deposit_success")
    public String showDepositSuccess() {
        return "savings/depositSuccess";
    }

    // Show withdraw success
    @GetMapping("/withdraw_success")
    public String showWithdrawSuccess() {
        return "savings/withdrawSuccess";
    }
}
