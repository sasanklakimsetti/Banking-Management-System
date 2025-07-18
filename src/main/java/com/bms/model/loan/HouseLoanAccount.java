package com.bms.model.loan;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "house_loan_accounts")
public class HouseLoanAccount extends LoanAccount{
//    public HouseLoanAccount(Double loanAmount, String collateralType, Double collateralValue, Integer durationInDays){
//        super.setLoanAmount(loanAmount);
//        super.setCollateralType(collateralType);
//        super.setCollateralValue(collateralValue);
//        super.setDurationInDays(durationInDays);
//    }
    public HouseLoanAccount(){
        super.setLoanType("House");
        super.setInterestRate(6.0);
    }
}
