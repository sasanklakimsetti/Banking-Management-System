package com.bms.repository.savings;

import com.bms.model.savings.StudentSavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSavingsAccountRepository extends JpaRepository<StudentSavingsAccount, Long> {
    List<StudentSavingsAccount> findAllByCustomerId_Customerid(Long customerId);

    StudentSavingsAccount findAByCustomerId_Customerid(Long customerId);
}
