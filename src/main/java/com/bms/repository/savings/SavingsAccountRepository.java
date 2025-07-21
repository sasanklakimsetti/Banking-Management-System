package com.bms.repository.savings;

import com.bms.model.savings.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    SavingsAccount findByCustomerId_Customerid(Long customerId);
    List<SavingsAccount> findAllByCustomerId_Customerid(Long customerId);
}
