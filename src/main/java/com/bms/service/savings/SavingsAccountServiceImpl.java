package com.bms.service.savings;

import com.bms.factory.SavingsAccountFactory;
import com.bms.model.Customer;
import com.bms.model.savings.SavingsAccount;
import com.bms.repository.CustomerRepository;
import com.bms.repository.savings.SavingsAccountRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Autowired
    private SavingsAccountFactory savingsAccountFactory;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public SavingsAccount openSavingsAccount(String accountType, Long customerId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        Customer customer = customerOpt.get();
        SavingsAccount account = savingsAccountFactory.createSavingsAccount(accountType);
        account.setCustomerId(customer);
        account.setBalance(0.0);

        return savingsAccountRepository.save(account);
    }

    @Override
    public SavingsAccount closeSavingsAccount(Long accountNumber) {
        SavingsAccount account = savingsAccountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Savings account not found"));

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
    public ResponseEntity<?> withdrawFromSavingsAccount(Long accountNumber, Integer amount) {
        SavingsAccount account = savingsAccountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) return new ResponseEntity<>("Insufficient Balance: "+account.getBalance(),HttpStatus.BAD_REQUEST);

        account.setBalance(account.getBalance() - amount);
        savingsAccountRepository.save(account);
        return new ResponseEntity<>("Amount withdrawn. New Balance: "+account.getBalance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> depositToSavingsAccount(Long accountNumber, Integer amount) {
        SavingsAccount account = savingsAccountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        savingsAccountRepository.save(account);
        return new ResponseEntity<>("Deposit successful. New balance: "+account.getBalance(),HttpStatus.OK);
    }
}
