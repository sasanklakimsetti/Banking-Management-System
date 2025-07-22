package com.bms.service.savings;

import com.bms.model.savings.SavingsAccount;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SavingsAccountService {

    SavingsAccount openSavingsAccount(String accountType, Long customerId);
    SavingsAccount closeSavingsAccount(Long accountNumber);

    List<SavingsAccount> getSavingsAccountsByCustomerId(Long customerId);
    List<SavingsAccount> getAllSavingsAccounts();

    ResponseEntity<?> withdrawFromSavingsAccount(Long accountNumber, Integer amount);
    ResponseEntity<?> depositToSavingsAccount(Long accountNumber, Integer amount);
}
