package com.bms.repository.savings;

import com.bms.model.savings.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    SavingsAccount findByCustomerId_CustomerId(Long customerId);
    List<SavingsAccount> findAllByCustomerId_CustomerId(Long customerId);

    Optional<SavingsAccount> findByAccountNumber(Long accountNumber);
}
