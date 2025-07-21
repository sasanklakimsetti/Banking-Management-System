package com.bms.repository.savings;

import com.bms.model.savings.PremiumSavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumSavingsAccountRepository extends JpaRepository<PremiumSavingsAccount, Long> {
    List<PremiumSavingsAccount> findAllByCustomerId_CustomerId(Long customerId);

    PremiumSavingsAccount findByCustomerId_CustomerId(Long customerId);
}
