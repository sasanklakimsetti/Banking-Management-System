package com.bms.service.loan;

import com.bms.model.loan.StudentLoanAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentLoanAccountService {
    List<StudentLoanAccount>getAllStudentLoanAccountsByCustomerId(Long customerId);
}
