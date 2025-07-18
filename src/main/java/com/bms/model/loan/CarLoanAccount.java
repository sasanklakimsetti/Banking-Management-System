package com.bms.model.loan;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_loan_accounts")
public class CarLoanAccount extends LoanAccount{
//    private CarLoanAccount(Double loanAmount, String collateralType, Double collateralValue, Integer durationInDays){
//        super.setLoanAmount(loanAmount);
//        super.setCollateralType(collateralType);
//        super.setCollateralValue(collateralValue);
//        super.setDurationInDays(durationInDays);
//    }
    public CarLoanAccount(){
        super.setLoanType("Car");
        super.setInterestRate(7.5);
    }
}
