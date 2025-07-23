package com.bms.repository;

import com.bms.model.Account;
import com.bms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.customerId.customerId = :customerId")
    Account findByCustomerId(@Param("customerId") Long customerId);
    Account findByCustomerId(Customer customerId);
    List<Account> findAccountsByCustomerId(Customer customerId);
}
