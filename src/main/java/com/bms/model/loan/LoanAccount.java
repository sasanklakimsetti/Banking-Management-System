package com.bms.model.loan;

import com.bms.model.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_accounts")
@PrimaryKeyJoinColumn(name = "account_number")
public class LoanAccount extends Account {
    private Double loanAmount;
    private String loanType;
    private String collateralType;
    private Double collateralValue;
    private Double interestRate;
    private Integer durationInDays;
    private Double emiAmount;

    public LoanAccount(){}

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(String collateralType) {
        this.collateralType = collateralType;
    }

    public Double getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(Double collateralValue) {
        this.collateralValue = collateralValue;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }

    public Double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount() {
        int numberOfMonths = durationInDays / 30;
        double monthlyInterestRate = interestRate / 100 / 12;
        this.emiAmount = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) /
                (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "loanAmount=" + loanAmount +
                ", loanType='" + loanType + '\'' +
                ", collateralType='" + collateralType + '\'' +
                ", collateralValue=" + collateralValue +
                ", interestRate=" + interestRate +
                ", durationInDays=" + durationInDays +
                ", emiAmount=" + emiAmount +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
