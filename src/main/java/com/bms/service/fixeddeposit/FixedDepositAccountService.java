package com.bms.service.fixeddeposit;

import com.bms.model.fixeddeposit.FixedDepositAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FixedDepositAccountService {
    FixedDepositAccount getAccountById(Long accountNumber);
    List<FixedDepositAccount>getAllAccounts();
    List<FixedDepositAccount> findAccountByCustomerId(Long customerId);
    FixedDepositAccount renewAccount(FixedDepositAccount account, Integer newDuration);
    FixedDepositAccount openAccount(FixedDepositAccount account);
    void calculateEarlyWithdrawal(FixedDepositAccount account);
    void withdraw(FixedDepositAccount account);
    FixedDepositAccount closeAccount(FixedDepositAccount account);
}
