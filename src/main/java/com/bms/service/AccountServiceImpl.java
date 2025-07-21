package com.bms.service;

import com.bms.model.Account;
import com.bms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account getAccountByAccountNumber(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(()->new IllegalArgumentException("Account not found"));
    }

    @Override
    public Account getAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }
}
