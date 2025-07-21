package com.bms.service;

import com.bms.model.Account;
import com.bms.repository.AccountRepository;
import com.bms.repository.fixeddeposit.FixedDepositAccountRepository;
import com.bms.repository.loan.LoanAccountRepository;
import com.bms.repository.savings.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<?> depositToAccount(Long accountNumber, Double amount){
        Optional<Account> optionalAccount=accountRepository.findById(accountNumber);
        if (optionalAccount.isEmpty()){
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
        Account account=optionalAccount.get();
        account.deposit(amount);
        accountRepository.save(account);
        return new ResponseEntity<>("Deposit successful. New balance: "+account.getBalance(),HttpStatus.OK);
    }
}
