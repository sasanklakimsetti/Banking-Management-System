package com.bms.service.savings;

import com.bms.factory.SavingsAccountFactory;
import com.bms.model.Account;
import com.bms.model.Customer;
import com.bms.model.savings.SavingsAccount;
import com.bms.repository.AccountRepository;
import com.bms.repository.CustomerRepository;
import com.bms.repository.savings.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SavingsAccountFactory savingsAccountFactory;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public SavingsAccount openSavingsAccount(String accountType, Long customerId) {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found"));
        SavingsAccount account=savingsAccountFactory.createSavingsAccount(accountType);
        account.setCustomerId(customer);
        return savingsAccountRepository.save(account);

    }

    @Override
    public SavingsAccount closeSavingsAccount(Long customerId) {
        SavingsAccount account=savingsAccountRepository.findByCustomerId_CustomerId(customerId);
        if(account==null) throw new RuntimeException("No savings account found for customer ID: " + customerId);
        savingsAccountRepository.delete(account);
        return account;
    }

    @Override
    public List<SavingsAccount> getSavingsAccountsByCustomerId(Long customerId) {
        return savingsAccountRepository.findAllByCustomerId_CustomerId(customerId);
    }

    @Override
    public List<SavingsAccount> getAllSavingsAccounts() {
        return savingsAccountRepository.findAll();
    }

    @Override
    public void withdrawMoney(Long accountNumber, Integer amount) {
        SavingsAccount account=savingsAccountRepository.findById(accountNumber)
                .orElseThrow(()->new RuntimeException("Account not found"));
        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient balance: "+account.getBalance());
        }
        account.withdraw(amount);
        savingsAccountRepository.save(account);
    }

    @Override
    public void depositMoney(Long accountNumber, Integer amount) {
        SavingsAccount account=savingsAccountRepository.findById(accountNumber)
                .orElseThrow(()->new RuntimeException("Account not found"));
        account.deposit((double) amount);
        savingsAccountRepository.save(account);
    }

    @Override
    public ResponseEntity<?> withdrawFromAccount(Long accountNumber, Integer amount){
        Optional<SavingsAccount> optionalAccount=savingsAccountRepository.findById(accountNumber);
        if (optionalAccount.isEmpty()){
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
        SavingsAccount account=optionalAccount.get();
        if(account.getBalance()<amount){
            return new ResponseEntity<>("Insufficient balance: " + account.getBalance(), HttpStatus.BAD_REQUEST);
        }
        account.withdraw(amount);
        accountRepository.save(account);
        return new ResponseEntity<>("Withdraw successful. New balance: "+account.getBalance(),HttpStatus.OK);
    }
}
