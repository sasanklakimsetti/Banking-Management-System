package com.bms.service.loan;

import com.bms.model.loan.HouseLoanAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseLoanAccountService {
    List<HouseLoanAccount> getAllHouseLoanAccountsByCustomerId(Long customerId);
}
