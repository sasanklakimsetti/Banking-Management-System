package com.bms.service.fixeddeposit;

import com.bms.factory.FixedDepositAccountFactory;
import com.bms.model.Customer;
import com.bms.model.fixeddeposit.FixedDepositAccount;
import com.bms.repository.CustomerRepository;
import com.bms.repository.fixeddeposit.FixedDepositAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class FixedDepositAccountServiceImpl implements FixedDepositAccountService {

    @Autowired
    private FixedDepositAccountRepository fixedDepositAccountRepository;

    @Autowired
    private FixedDepositAccountFactory fixedDepositAccountFactory;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<?> getAccountById(Long accountNumber) {
        Optional<FixedDepositAccount> optionalAccount = fixedDepositAccountRepository.findById(accountNumber);

        return optionalAccount
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Account not found with account number: " + accountNumber));
    }

    @Override
    public ResponseEntity<List<FixedDepositAccount>> getAllAccounts() {
        return new ResponseEntity<>(fixedDepositAccountRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FixedDepositAccount>> findAccountByCustomerId(Long customerId) {
        List<FixedDepositAccount> accounts = fixedDepositAccountRepository.findByCustomerId_CustomerId(customerId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> renewAccount(Long accountNumber, Integer newDuration) {
        Optional<FixedDepositAccount> optionalAccount = fixedDepositAccountRepository.findById(accountNumber);

        if (optionalAccount.isEmpty()) {
            return new ResponseEntity<>("Account not found with account number: " + accountNumber, HttpStatus.NOT_FOUND);
        }

        FixedDepositAccount account = optionalAccount.get();

        if (newDuration < FixedDepositAccount.fixedDurations.get(0)) {
            return new ResponseEntity<>(
                    "Duration must be at least " + FixedDepositAccount.fixedDurations.get(0) + " days",
                    HttpStatus.BAD_REQUEST
            );
        }

        account.setDuration(newDuration);
        account.setDueDate();
        account.setTotalPayout(account.getTotalPayout());
        fixedDepositAccountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> openAccount(Long customerId, FixedDepositAccount account) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isEmpty()) {
            return new ResponseEntity<>("Customer not found with ID: " + customerId, HttpStatus.NOT_FOUND);
        }

        try {
            FixedDepositAccount newAccount = fixedDepositAccountFactory.createFixedDepositAccount(
                    account.getDepositAmount(),
                    account.getDuration()
            );
            newAccount.setCustomerId(optionalCustomer.get());
            newAccount.setBalance(account.getDepositAmount());

            FixedDepositAccount saved = fixedDepositAccountRepository.save(newAccount);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> calculateEarlyWithdrawal(Long accountNumber) {
        Optional<FixedDepositAccount> optionalAccount = fixedDepositAccountRepository.findById(accountNumber);

        if (optionalAccount.isEmpty()) {
            return new ResponseEntity<>("Account not found with account number: " + accountNumber, HttpStatus.NOT_FOUND);
        }

        FixedDepositAccount account = optionalAccount.get();

        account.getDaysHeld();
        account.setExpectedPayout(account.getTotalPayout()); // Replace with real calculation logic if needed
        account.setBalance(0.0);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> withdraw(Long accountNumber) {
        Optional<FixedDepositAccount> optionalAccount = fixedDepositAccountRepository.findById(accountNumber);

        if (optionalAccount.isEmpty()) {
            return new ResponseEntity<>("Account not found with account number: " + accountNumber, HttpStatus.NOT_FOUND);
        }

        FixedDepositAccount account = optionalAccount.get();
        Integer daysHeld = account.getDaysHeld();

        if (daysHeld == null && account.getCreationDate() != null) {
            LocalDate createdDate = account.getCreationDate().toLocalDate();
            daysHeld = (int) ChronoUnit.DAYS.between(createdDate, LocalDate.now());
        }

        if (daysHeld == null) daysHeld = 0;

        boolean isPremature = daysHeld < account.getDuration();
        if (isPremature) {
            account.setExpectedPayout(account.getTotalPayout()); // Optionally apply penalty
        }

        // ✅ Ensure balance is set to 0 and saved
        account.setBalance(0.0);
        fixedDepositAccountRepository.save(account);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }



    @Override
    @Transactional
    public ResponseEntity<?> closeAccount(Long accountNumber) {
        Optional<FixedDepositAccount> optionalAccount = fixedDepositAccountRepository.findById(accountNumber);

        if (optionalAccount.isEmpty()) {
            return new ResponseEntity<>("Account not found with account number: " + accountNumber, HttpStatus.NOT_FOUND);
        }

        fixedDepositAccountRepository.deleteById(accountNumber);
        return new ResponseEntity<>("Account closed successfully", HttpStatus.OK);
    }
}
