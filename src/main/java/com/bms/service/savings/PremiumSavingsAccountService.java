package com.bms.service.savings;

import com.bms.model.savings.PremiumSavingsAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PremiumSavingsAccountService {
    List<PremiumSavingsAccount> getAllPremiumSavingsAccounts();
    List<PremiumSavingsAccount> getAllPremiumSavingsAccountsByCustomerId(Long customerId);
    PremiumSavingsAccount getPremiumSavingsAccountByCustomerId(Long customerId);
}
