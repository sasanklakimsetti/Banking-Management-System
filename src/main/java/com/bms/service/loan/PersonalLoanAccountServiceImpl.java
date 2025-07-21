package com.bms.service.loan;

import com.bms.model.loan.PersonalLoanAccount;
import com.bms.repository.loan.PersonalLoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalLoanAccountServiceImpl implements PersonalLoanAccountService{

    @Autowired
    private PersonalLoanAccountRepository personalLoanAccountRepository;
    @Override
    public List<PersonalLoanAccount> getAllPersonalLoanAccountsByCustomerId(Long customerId) {
        return personalLoanAccountRepository.findByCustomerId_CustomerId(customerId);
    }
}
