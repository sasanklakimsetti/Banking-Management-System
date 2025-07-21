package com.bms.service.savings;

import com.bms.model.savings.BasicSavingsAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasicSavingsAccountService {
    List<BasicSavingsAccount> getAllBasicSavingsAccounts();
    List<BasicSavingsAccount> getAllBasicSavingsAccountsByCustomerId(Long customerId);
    BasicSavingsAccount getBasicSavingsAccountByCustomerId(Long customerId);
}
