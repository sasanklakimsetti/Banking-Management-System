package com.bms.service.savings;

import com.bms.model.savings.RegularSavingsAccount;
import com.bms.repository.savings.RegularSavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularSavingsAccountServiceImpl implements RegularSavingsAccountService{

    @Autowired
    private RegularSavingsAccountRepository regularSavingsAccountRepository;
    @Override
    public List<RegularSavingsAccount> getAllRegularSavingsAccounts() {
        return regularSavingsAccountRepository.findAll();
    }

    @Override
    public List<RegularSavingsAccount> getAllRegularSavingsAccountsByCustomerId(Long customerId) {
        return regularSavingsAccountRepository.findAllByCustomerId_Customerid(customerId);
    }

    @Override
    public RegularSavingsAccount getRegularSavingsAccountByCustomerId(Long customerId) {
        return regularSavingsAccountRepository.findByCustomerId_Customerid(customerId);
    }
}
