package com.bms.service;

import com.bms.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    Account getAccountByAccountNumber(Long accountNumber);
    List<Account> getAccountsByCustomerId(Long customerId);
    ResponseEntity<?>depositToAccount(Long accountNumber, Double amount);
}
