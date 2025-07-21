package com.bms.service.loan;

import com.bms.model.loan.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanAccountService {
    LoanAccount openAccount(LoanAccount account);
    void payEmi(Long accountNumber, Double amount);
    Double getOutstandingAmount(Long accountNumber);
    List<LoanAccount> getAllLoanAccounts();
    List<LoanAccount> getAllAccountsByCustomerId(Long customerId);
    LoanAccount closeAccount(Long accountNumber);
    List<StudentLoanAccount>getAllStudentLoanAccounts();
    List<PersonalLoanAccount>getAllPersonalLoanAccounts();
    List<CarLoanAccount>getAllCarLoanAccounts();
    List<HouseLoanAccount>getAllHouseLoanAccounts();
}
