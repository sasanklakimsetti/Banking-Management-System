package com.bms.service.savings;

import com.bms.model.savings.BasicSavingsAccount;
import com.bms.repository.savings.BasicSavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicSavingsAccountServiceImpl implements BasicSavingsAccountService{

    @Autowired
    private BasicSavingsAccountRepository basicSavingsAccountRepository;
    @Override
    public List<BasicSavingsAccount> getAllBasicSavingsAccounts() {
        return basicSavingsAccountRepository.findAll();
    }

    @Override
    public List<BasicSavingsAccount> getAllBasicSavingsAccountsByCustomerId(Long customerId) {
        return basicSavingsAccountRepository.findAllByCustomerId_CustomerId(customerId);
    }

    @Override
    public BasicSavingsAccount getBasicSavingsAccountByCustomerId(Long customerId) {
        return basicSavingsAccountRepository.findByCustomerId_CustomerId(customerId);
    }
}
