package com.bms.repository.savings;

import com.bms.model.savings.RegularSavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegularSavingsAccountRepository extends JpaRepository<RegularSavingsAccount, Long> {
    List<RegularSavingsAccount> findAllByCustomerId_CustomerId(Long customerId);

    RegularSavingsAccount findByCustomerId_CustomerId(Long customerId);
}
