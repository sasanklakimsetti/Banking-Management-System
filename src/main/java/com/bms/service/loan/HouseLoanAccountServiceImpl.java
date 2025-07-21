package com.bms.service.loan;

import com.bms.model.loan.HouseLoanAccount;
import com.bms.repository.loan.HouseLoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseLoanAccountServiceImpl implements HouseLoanAccountService{

    @Autowired
    private HouseLoanAccountRepository houseLoanAccountRepository;


    @Override
    public List<HouseLoanAccount> getAllHouseLoanAccountsByCustomerId(Long customerId) {
        return houseLoanAccountRepository.findByCustomerId_CustomerId(customerId);
    }
}
