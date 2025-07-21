package com.bms.repository.loan;

import com.bms.model.loan.HouseLoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseLoanAccountRepository extends JpaRepository<HouseLoanAccount, Long> {
    List<HouseLoanAccount> findByCustomerId_CustomerId(Long customerId);
}
