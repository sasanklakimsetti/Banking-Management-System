package com.bms.service.fixeddeposit;

import com.bms.model.fixeddeposit.FixedDepositAccount;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FixedDepositAccountService {
    ResponseEntity<?> getAccountById(Long accountNumber);
    ResponseEntity<List<FixedDepositAccount>> getAllAccounts();
    ResponseEntity<List<FixedDepositAccount>> findAccountByCustomerId(Long customerId);
    ResponseEntity<?> renewAccount(Long accountNumber, Integer newDuration);
    ResponseEntity<?> openAccount(Long customerId, FixedDepositAccount account);
    ResponseEntity<?> calculateEarlyWithdrawal(Long accountNumber);
    ResponseEntity<?> withdraw(Long accountNumber);
    ResponseEntity<?> closeAccount(Long accountNumber);
}
