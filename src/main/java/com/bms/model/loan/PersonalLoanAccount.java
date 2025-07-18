package com.bms.model.loan;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal_loan_accounts")
public class PersonalLoanAccount extends LoanAccount{
//    public PersonalLoanAccount(Double loanAmount, String collateralType, Double collateralValue, Integer durationInDays){
//        super.setLoanAmount(loanAmount);
//        super.setCollateralType(collateralType);
//        super.setCollateralValue(collateralValue);
//        super.setDurationInDays(durationInDays);
//    }
    public PersonalLoanAccount(){
        super.setLoanType("Personal");
        super.setInterestRate(9.5);
    }
}
