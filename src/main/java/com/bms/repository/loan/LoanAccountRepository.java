package com.bms.repository.loan;

import com.bms.model.loan.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount, Long> {

    List<LoanAccount> findByCustomerId_Customerid(Long customerId);

    @Query("select s from StudentLoanAccount s")
    List<StudentLoanAccount>getAllStudentLoanAccounts();

    @Query("select c from CarLoanAccount c")
    List<CarLoanAccount>getAllCarLoanAccounts();

    @Query("select p from PersonalLoanAccount p")
    List<PersonalLoanAccount>getAllPersonalLoanAccounts();

    @Query("select h from HouseLoanAccount h")
    List<HouseLoanAccount>getAllHouseLoanAccounts();
}
