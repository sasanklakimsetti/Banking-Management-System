package com.bms.repository.savings;

import com.bms.model.savings.BasicSavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicSavingsAccountRepository extends JpaRepository<BasicSavingsAccount, Long> {
    List<BasicSavingsAccount> findAllByCustomerId_Customerid(Long customerId);

    BasicSavingsAccount findByCustomerId_Customerid(Long customerId);
}
