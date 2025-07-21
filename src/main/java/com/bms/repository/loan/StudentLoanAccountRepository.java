package com.bms.repository.loan;

import com.bms.model.loan.StudentLoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentLoanAccountRepository extends JpaRepository<StudentLoanAccount, Long> {
    List<StudentLoanAccount> findByCustomerId_CustomerId(Long customerId);
}
