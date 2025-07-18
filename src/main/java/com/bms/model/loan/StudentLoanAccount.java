package com.bms.model.loan;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_loan_accounts")
public class StudentLoanAccount extends LoanAccount{
//    public StudentLoanAccount(Double loanAmount, String collateralType, Double collateralValue, Integer durationInDays){
//        super.setLoanAmount(loanAmount);
//        super.setCollateralType(collateralType);
//        super.setCollateralValue(collateralValue);
//        super.setDurationInDays(durationInDays);
//    }
    public StudentLoanAccount(){
        super.setLoanType("Student");
        super.setInterestRate(4.5);
    }
}
