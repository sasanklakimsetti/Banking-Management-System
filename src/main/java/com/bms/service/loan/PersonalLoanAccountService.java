package com.bms.service.loan;

import com.bms.model.loan.PersonalLoanAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalLoanAccountService {
    List<PersonalLoanAccount> getAllPersonalLoanAccountsByCustomerId(Long customerId);
}
