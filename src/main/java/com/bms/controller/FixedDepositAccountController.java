package com.bms.controller;

import com.bms.model.fixeddeposit.FixedDepositAccount;
import com.bms.service.fixeddeposit.FixedDepositAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/fixed_deposit")
public class FixedDepositAccountController {

    @Autowired
    private FixedDepositAccountService fixedDepositAccountService;

    // Show the FD creation form
    @GetMapping("/create_account")
    public String showCreateForm(@RequestParam Long customerId, Model model) {
        model.addAttribute("customerId", customerId);
        return "fixed_deposit/openFixedDeposit";
    }

    // Handle FD creation form submission
    @PostMapping("/create_account")
    public String openFixedDeposit(
            @ModelAttribute FixedDepositAccount account,
            @RequestParam Long customerId,
            Model model
    ) {
        System.out.println("➡️ depositAmount from form: " + account.getDepositAmount());
        System.out.println("➡️ balance before setting: " + account.getBalance());
        ResponseEntity<?> response = fixedDepositAccountService.openAccount(customerId, account);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() instanceof FixedDepositAccount created) {
            model.addAttribute("accountNumber", created.getAccountNumber());
            model.addAttribute("dueDate", created.getDueDate());
            model.addAttribute("totalPayout", created.getTotalPayout());
            return "fixed_deposit/accountCreated"; // JSP will use JS to show this info
        } else {
            model.addAttribute("error", response.getBody());
            return "error";
        }
    }

    // Show the FD renewal form
    @GetMapping("/renew_account")
    public String showRenewForm(@RequestParam Long accountNumber, Model model) {
        model.addAttribute("accountNumber", accountNumber);
        return "fixed_deposit/renewFixedDeposit";
    }

    // Handle FD renewal form submission
    @PostMapping("/renew_account")
    public String renewFixedDeposit(
            @RequestParam Long accountNumber,
            @RequestParam Integer newDuration,
            Model model
    ) {
        ResponseEntity<?> response = fixedDepositAccountService.renewAccount(accountNumber, newDuration);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() instanceof FixedDepositAccount renewed) {
            model.addAttribute("dueDate", renewed.getDueDate());
            model.addAttribute("totalPayout", renewed.getTotalPayout());
            return "fixed_deposit/accountRenewed";
        }

        model.addAttribute("error", response.getBody());
        return "error";
    }

    // Handle withdrawal POST request
    @PostMapping("/withdraw")
    public String withdrawFromFixedDeposit(@RequestParam Long accountNumber, Model model) {
        ResponseEntity<?> response = fixedDepositAccountService.withdraw(accountNumber);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() instanceof FixedDepositAccount account) {
            boolean isPremature = account.getDaysHeld() < account.getDuration();
            model.addAttribute("payoutAmount", isPremature ? account.getExpectedPayout() : account.getTotalPayout());
            model.addAttribute("isPremature", isPremature);
            return "fixed_deposit/withdrawalSuccess"; // Must match actual JSP name
        }

        model.addAttribute("error", response.getBody());
        return "error";
    }




    // Success page after withdrawal
    @GetMapping("/withdraw_success")
    public String showWithdrawSuccessPage() {
        return "fixed_deposit/withdrawalSuccess";
    }

    // Close FD account
    @PostMapping("/close_account")
    public String closeFixedDeposit(@RequestParam Long accountNumber, Model model) {
        ResponseEntity<?> response = fixedDepositAccountService.closeAccount(accountNumber);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "fixed_deposit/accountClosed";
        }

        model.addAttribute("error", response.getBody());
        return "error";
    }
}
