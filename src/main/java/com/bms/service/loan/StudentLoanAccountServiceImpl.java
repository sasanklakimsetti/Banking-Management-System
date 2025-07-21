package com.bms.service.loan;

import com.bms.model.loan.StudentLoanAccount;
import com.bms.repository.loan.StudentLoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLoanAccountServiceImpl implements StudentLoanAccountService{

    @Autowired
    private StudentLoanAccountRepository studentLoanAccountRepository;
    @Override
    public List<StudentLoanAccount> getAllStudentLoanAccountsByCustomerId(Long customerId) {
        return studentLoanAccountRepository.findByCustomerId_CustomerId(customerId);
    }
}
