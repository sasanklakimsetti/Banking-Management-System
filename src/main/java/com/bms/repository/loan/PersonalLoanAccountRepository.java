package com.bms.repository.loan;

import com.bms.model.loan.PersonalLoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalLoanAccountRepository extends JpaRepository<PersonalLoanAccount, Long> {

    List<PersonalLoanAccount> findByCustomerId_CustomerId(Long customerId);
}
