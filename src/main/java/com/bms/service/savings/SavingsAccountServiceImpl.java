package com.bms.service.savings;

import com.bms.factory.SavingsAccountFactory;
import com.bms.model.Customer;
import com.bms.model.savings.SavingsAccount;
import com.bms.repository.CustomerRepository;
import com.bms.repository.savings.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SavingsAccountFactory savingsAccountFactory;
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
}
