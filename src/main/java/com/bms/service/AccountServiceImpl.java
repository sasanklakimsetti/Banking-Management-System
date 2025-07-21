package com.bms.service;

import com.bms.model.Account;
import com.bms.repository.AccountRepository;
import com.bms.repository.fixeddeposit.FixedDepositAccountRepository;
import com.bms.repository.loan.LoanAccountRepository;
import com.bms.repository.savings.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private FixedDepositAccountRepository fixedDepositAccountRepository;
    @Autowired
    private LoanAccountRepository loanAccountRepository;
    @Override
    public Account getAccountByAccountNumber(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(()->new IllegalArgumentException("Account not found"));
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long customerId) {
        List<Account>accounts=new ArrayList<>();
        accounts.addAll(savingsAccountRepository.findAllByCustomerId_CustomerId(customerId));
        accounts.addAll(loanAccountRepository.findByCustomerId_CustomerId(customerId));
        accounts.addAll(fixedDepositAccountRepository.findByCustomerId_CustomerId(customerId));
        return accounts;
    }
}
