package com.bms.service.loan;

import com.bms.factory.LoanAccountFactory;
import com.bms.model.loan.*;
import com.bms.repository.loan.LoanAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAccountServiceImpl implements LoanAccountService{

    @Autowired
    private LoanAccountRepository loanAccountRepository;

    @Autowired
    private LoanAccountFactory loanAccountFactory;


    @Override
    public LoanAccount openAccount(LoanAccount account) {
        String loanType=account.getLoanType();
        if("Car".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createCarLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            return loanAccountRepository.save(newAccount);
        }
        else if("House".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createHouseLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            return loanAccountRepository.save(newAccount);
        }
        else if("Personal".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createPersonalLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            return loanAccountRepository.save(newAccount);
        }
        else if("Student".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createStudentLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            return loanAccountRepository.save(newAccount);
        }
        throw new IllegalArgumentException("Unsupported loan type: "+loanType);
    }

    @Override
    @Transactional
    public void payEmi(Long accountNumber, Double amount) {
        LoanAccount account=loanAccountRepository.findById(accountNumber).orElseThrow(
                ()-> new IllegalArgumentException("Account number: "+accountNumber+" not found"));
        if(amount<account.getEmiAmount()) throw new IllegalArgumentException("Amount is less than EMI");

        account.deposit(amount);
        loanAccountRepository.save(account);
    }

    @Override
    public Double getOutstandingAmount(Long accountNumber) {
        LoanAccount account=loanAccountRepository.findById(accountNumber).orElseThrow(
                ()-> new IllegalArgumentException("Account number: "+accountNumber+" not found"));
        return loanAccountRepository.findById(accountNumber)
                .map(LoanAccount::getBalance)
                .orElse(0.0);
    }

    @Override
    public List<LoanAccount> getAllLoanAccounts() {
        return loanAccountRepository.findAll();
    }

    @Override
    public List<LoanAccount> getAllAccountsByCustomerId(Long customerId) {
        return loanAccountRepository.findByCustomerId_CustomerId(customerId);
    }

    @Override
    public LoanAccount closeAccount(Long accountNumber) {
        LoanAccount account=loanAccountRepository.findById(accountNumber).orElseThrow(
                ()-> new IllegalArgumentException("Account number: "+accountNumber+" not found"));
        account.setBalance(0.0);
        return loanAccountRepository.save(account);
    }

    @Override
    public List<StudentLoanAccount> getAllStudentLoanAccounts() {
        return loanAccountRepository.getAllStudentLoanAccounts();
    }

    @Override
    public List<PersonalLoanAccount> getAllPersonalLoanAccounts() {
        return loanAccountRepository.getAllPersonalLoanAccounts();
    }

    @Override
    public List<CarLoanAccount> getAllCarLoanAccounts() {
        return loanAccountRepository.getAllCarLoanAccounts();
    }

    @Override
    public List<HouseLoanAccount> getAllHouseLoanAccounts() {
        return loanAccountRepository.getAllHouseLoanAccounts();
    }
}
