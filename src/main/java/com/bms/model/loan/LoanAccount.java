package com.bms.model.loan;

import com.bms.model.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Entity
@Table(name = "loan_accounts")
@PrimaryKeyJoinColumn(name = "accountNumber")
public class LoanAccount extends Account {
    private Double loanAmount;
    private String loanType;
    private String collateralType;
    private Double collateralValue;
    private Double interestRate;
    private Integer durationInDays;
    private Double emiAmount;
    private Integer remainingTenure;

    public Integer getRemainingTenure() {
        return Math.toIntExact(ChronoUnit.DAYS.between((Temporal) super.getCreationDate(), LocalDate.now()));
    }

    public void setRemainingTenure(Integer remainingTenure) {
        this.remainingTenure = remainingTenure;
    }

    public LoanAccount(){
    }

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

    public void setEmiAmount(Double emiAmount) {
        this.emiAmount=emiAmount;
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
                ","+
                '}';
    }
}
