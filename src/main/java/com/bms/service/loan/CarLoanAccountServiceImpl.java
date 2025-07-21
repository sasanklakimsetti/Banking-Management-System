package com.bms.service.loan;

import com.bms.model.loan.CarLoanAccount;
import com.bms.repository.loan.CarLoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarLoanAccountServiceImpl implements CarLoanAccountService{
    @Autowired
    private CarLoanAccountRepository carLoanAccountRepository;

    @Override
    public List<CarLoanAccount> getAllCarLoanAccountsByCustomerId(Long customerId) {
        return carLoanAccountRepository.findByCustomerId_CustomerId(customerId);
    }
}
