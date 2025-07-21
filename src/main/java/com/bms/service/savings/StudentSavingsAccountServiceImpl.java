package com.bms.service.savings;

import com.bms.model.loan.StudentLoanAccount;
import com.bms.model.savings.StudentSavingsAccount;
import com.bms.repository.savings.StudentSavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSavingsAccountServiceImpl implements StudentSavingsAccountService {
    @Autowired
    private StudentSavingsAccountRepository studentSavingsAccountRepository;
    @Override
    public List<StudentSavingsAccount> getAllStudentSavingsAccounts() {
        return studentSavingsAccountRepository.findAll();
    }

    @Override
    public List<StudentSavingsAccount> getAllStudentSavingsAccountsByCustomerId(Long customerId) {
        return studentSavingsAccountRepository.findAllByCustomerId_CustomerId(customerId);
    }

    @Override
    public StudentSavingsAccount getStudentSavingsAccountByCustomerId(Long customerId) {
        return studentSavingsAccountRepository.findAByCustomerId_CustomerId(customerId);
    }
}
