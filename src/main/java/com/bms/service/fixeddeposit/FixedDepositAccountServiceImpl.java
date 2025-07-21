package com.bms.service.fixeddeposit;

import com.bms.factory.FixedDepositAccountFactory;
import com.bms.model.fixeddeposit.FixedDepositAccount;
import com.bms.repository.fixeddeposit.FixedDepositAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedDepositAccountServiceImpl implements FixedDepositAccountService{

    @Autowired
    private FixedDepositAccountRepository fixedDepositAccountRepository;

    @Autowired
    private FixedDepositAccountFactory fixedDepositAccountFactory;

    @Override
    public FixedDepositAccount getAccountById(Long accountNumber) {
        return fixedDepositAccountRepository.findById(accountNumber)
                .orElseThrow(()->new IllegalArgumentException("Account not found with the account number: "+accountNumber));
    }

    @Override
    public List<FixedDepositAccount> getAllAccounts() {
        return fixedDepositAccountRepository.findAll();
    }

    @Override
    public List<FixedDepositAccount> findAccountByCustomerId(Long customerId) {
        return fixedDepositAccountRepository.findByCustomerId_CustomerId(customerId);
    }

    @Override
    public FixedDepositAccount renewAccount(FixedDepositAccount account, Integer newDuration) {
        if(newDuration<FixedDepositAccount.fixedDurations.get(0)){
            throw new IllegalArgumentException("Fixed Deposit duration can't be less than "+FixedDepositAccount.fixedDurations.get(0)+" days");
        }
        account.setDueDate();
        account.setTotalPayout(account.getTotalPayout());
        return fixedDepositAccountRepository.save(account);
    }

    @Override
    public FixedDepositAccount openAccount(FixedDepositAccount account) {
        FixedDepositAccount newAccount=fixedDepositAccountFactory.createFixedDepositAccount(
                account.getDepositAmount(),
                account.getDuration()
        );
        newAccount.setCustomerId(account.getCustomerId());
        return fixedDepositAccountRepository.save(newAccount);
    }

    @Override
    public void calculateEarlyWithdrawal(FixedDepositAccount account) {
        account.getDaysHeld();
        account.setExpectedPayout(account.getTotalPayout());
    }

    @Override
    @Transactional
    public void withdraw(FixedDepositAccount account) {
        if (account.getDaysHeld() >= account.getDuration()) {
            System.out.println("Matured! You receive: Rs. " + account.getTotalPayout());
        } else {
            calculateEarlyWithdrawal(account);
            System.out.println("Premature withdrawal. You receive: Rs. " + account.getExpectedPayout());
        }
        account.setBalance(0.0);
    }

    @Override
    @Transactional
    public FixedDepositAccount closeAccount(FixedDepositAccount account) {
        FixedDepositAccount existingAccount=fixedDepositAccountRepository.findById(account.getAccountNumber())
                .orElseThrow(()->new IllegalArgumentException("Account not found"));
        fixedDepositAccountRepository.deleteById(account.getAccountNumber());
        return existingAccount;
    }
}
