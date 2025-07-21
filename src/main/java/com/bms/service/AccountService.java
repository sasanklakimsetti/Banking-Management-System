package com.bms.service;

import com.bms.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account getAccountByAccountNumber(Long accountNumber);
    Account getAccountsByCustomerId(Long customerId);
}
