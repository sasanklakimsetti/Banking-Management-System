package com.bms.service.savings;

import com.bms.model.savings.SavingsAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SavingsAccountService {
    SavingsAccount openSavingsAccount(String accountType, Long customerId);
    SavingsAccount closeSavingsAccount(Long customerId);
    List<SavingsAccount> getSavingsAccountsByCustomerId(Long customerId);
    List<SavingsAccount> getAllSavingsAccounts();
    void withdrawMoney(Long accountNumber, Integer amount);
    void depositMoney(Long accountNumber, Integer amount);

    ResponseEntity<?> withdrawFromAccount(Long accountNumber, Integer amount);
}
