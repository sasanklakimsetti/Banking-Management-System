package com.bms.repository.loan;

import com.bms.model.loan.CarLoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarLoanAccountRepository extends JpaRepository<CarLoanAccount, Long> {
    List<CarLoanAccount> findByCustomerId_CustomerId(Long customerId);
}
