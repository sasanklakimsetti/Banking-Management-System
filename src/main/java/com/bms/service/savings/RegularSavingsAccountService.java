package com.bms.service.savings;

import com.bms.model.savings.RegularSavingsAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegularSavingsAccountService {
    List<RegularSavingsAccount> getAllRegularSavingsAccounts();
    List<RegularSavingsAccount> getAllRegularSavingsAccountsByCustomerId(Long customerId);
    RegularSavingsAccount getRegularSavingsAccountByCustomerId(Long customerId);
}
