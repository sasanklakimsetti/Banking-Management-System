package com.bms.service.savings;

import com.bms.model.savings.PremiumSavingsAccount;
import com.bms.repository.savings.PremiumSavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumSavingsAccountServiceImpl implements PremiumSavingsAccountService{

    @Autowired
    private PremiumSavingsAccountRepository premiumSavingsAccountRepository;
    @Override
    public List<PremiumSavingsAccount> getAllPremiumSavingsAccounts() {
        return premiumSavingsAccountRepository.findAll();
    }

    @Override
    public List<PremiumSavingsAccount> getAllPremiumSavingsAccountsByCustomerId(Long customerId) {
        return premiumSavingsAccountRepository.findAllByCustomerId_CustomerId(customerId);
    }

    @Override
    public PremiumSavingsAccount getPremiumSavingsAccountByCustomerId(Long customerId) {
        return premiumSavingsAccountRepository.findByCustomerId_CustomerId(customerId);
    }
}
