package com.bms.service.loan;

import com.bms.model.loan.CarLoanAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarLoanAccountService {
    List<CarLoanAccount> getAllCarLoanAccountsByCustomerId(Long customerId);
}
