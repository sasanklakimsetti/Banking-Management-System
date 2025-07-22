package com.bms.controller;

import com.bms.model.fixeddeposit.FixedDepositAccount;
import com.bms.repository.fixeddeposit.FixedDepositAccountRepository;
import com.bms.service.fixeddeposit.FixedDepositAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fixed_deposit")
public class FixedDepositAccountController {

    @Autowired
    private FixedDepositAccountService fixedDepositAccountService;

    @Autowired
    private FixedDepositAccountRepository fixedDepositAccountRepository;

    @PostMapping("/create_account/{customerId}")
    public ResponseEntity<?> openFixedDeposit(@PathVariable Long customerId,
                                              @RequestBody FixedDepositAccount account) {
        return fixedDepositAccountService.openAccount(customerId, account);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<?> getFixedDepositById(@PathVariable Long accountNumber) {
        return fixedDepositAccountService.getAccountById(accountNumber);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getAccountsByCustomerId(@PathVariable Long customerId) {
        return fixedDepositAccountService.findAccountByCustomerId(customerId);
    }

    @PutMapping("/renew_account/{accountNumber}")
    public ResponseEntity<?> renewFixedDeposit(@PathVariable Long accountNumber,
                                               @RequestParam Integer newDuration) {
        FixedDepositAccount account=fixedDepositAccountRepository.findById(accountNumber).orElse(null);
        if (account==null) return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        return fixedDepositAccountService.renewAccount(account, newDuration);
    }

    @DeleteMapping("/close_account/{accountNumber}")
    public ResponseEntity<?> closeFixedDeposit(@PathVariable Long accountNumber) {
        FixedDepositAccount account=fixedDepositAccountRepository.findById(accountNumber).orElse(null);
        if (account==null) return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        return fixedDepositAccountService.closeAccount(account);
    }

    @PutMapping("/withdraw/{accountNumber}")
    public ResponseEntity<?> withdrawFromFixedDeposit(@PathVariable Long accountNumber) {
        FixedDepositAccount account=fixedDepositAccountRepository.findById(accountNumber).orElse(null);
        if (account==null) return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        return fixedDepositAccountService.withdraw(account);
    }
}
