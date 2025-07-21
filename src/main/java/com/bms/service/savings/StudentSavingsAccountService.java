package com.bms.service.savings;

import com.bms.model.savings.StudentSavingsAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentSavingsAccountService {
    List<StudentSavingsAccount> getAllStudentSavingsAccounts();
    List<StudentSavingsAccount> getAllStudentSavingsAccountsByCustomerId(Long customerId);
    StudentSavingsAccount getStudentSavingsAccountByCustomerId(Long customerId);
}
