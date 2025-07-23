package com.bms.service.loan;

import com.bms.factory.LoanAccountFactory;
import com.bms.model.loan.*;
import com.bms.repository.loan.LoanAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanAccountServiceImpl implements LoanAccountService{

    @Autowired
    private LoanAccountRepository loanAccountRepository;

    @Autowired
    private LoanAccountFactory loanAccountFactory;


    @Override
    public LoanAccount openAccount(LoanAccount account) {
        String loanType=account.getLoanType();
        if (account.getLoanAmount() == null || account.getDurationInDays() == null) throw new IllegalArgumentException("Loan amount and duration are required");
        if("Car".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createCarLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            newAccount.setCustomerId(account.getCustomerId());
            newAccount.setLoanType("Car");
            return loanAccountRepository.save(newAccount);
        }
        else if("House".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createHouseLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            newAccount.setCustomerId(account.getCustomerId());
            newAccount.setLoanType("House");
            return loanAccountRepository.save(newAccount);
        }
        else if("Personal".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createPersonalLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            newAccount.setCustomerId(account.getCustomerId());
            newAccount.setLoanType("Personal");
            return loanAccountRepository.save(newAccount);
        }
        else if("Student".equalsIgnoreCase(loanType)){
            LoanAccount newAccount=loanAccountFactory.createStudentLoanAccount(account.getLoanAmount(),account.getCollateralType(),account.getCollateralValue(),account.getDurationInDays());
            newAccount.setCustomerId(account.getCustomerId());
            newAccount.setLoanType("Student");
            return loanAccountRepository.save(newAccount);
        }
        throw new IllegalArgumentException("Unsupported loan type: "+loanType);
    }

    @Override
    @Transactional
    public ResponseEntity<?> payEmi(Long accountNumber, Double amount) {
        Optional<LoanAccount> optionalAccount = loanAccountRepository.findById(accountNumber);
        if (optionalAccount.isEmpty()) {
            return new ResponseEntity<>("Account number: " + accountNumber + " not found", HttpStatus.NOT_FOUND);
        }
        LoanAccount account=optionalAccount.get();
        if (account==null) return new ResponseEntity<>("Account not found with account number: "+accountNumber, HttpStatus.NOT_FOUND);
        if(amount<account.getEmiAmount()) return new ResponseEntity<>("Amount is less than EMI",HttpStatus.BAD_REQUEST);

        account.deposit(amount);
        loanAccountRepository.save(account);
        return new ResponseEntity<>("Payment successful. Updated Balance: "+account.getBalance(), HttpStatus.OK);
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
