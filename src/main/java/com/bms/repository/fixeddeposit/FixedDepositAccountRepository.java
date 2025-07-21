package com.bms.repository.fixeddeposit;

import com.bms.model.fixeddeposit.FixedDepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedDepositAccountRepository extends JpaRepository<FixedDepositAccount, Long> {
    public List<FixedDepositAccount>findByCustomerId_CustomerId(Long customerId);
}
