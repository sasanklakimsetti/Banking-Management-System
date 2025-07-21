package com.bms.model.fixeddeposit;

import com.bms.model.Account;
import com.sun.jdi.DoubleValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;

@Entity
@Table(name = "fixed_deposit_accounts")
@PrimaryKeyJoinColumn(name = "accountNumber")
public class FixedDepositAccount extends Account {
    private Double depositAmount;
    private Integer duration;
    private Date dueDate;
    private Double interestRate;
    private Integer daysHeld;
    private Double expectedPayout;
    private Double totalPayout;

    public static  ArrayList<Integer> fixedDurations=new ArrayList<>(Arrays.asList(7, 14, 30, 45, 60, 90, 120, 180, 270, 365, 400, 500, 555, 600, 666, 700, 730, 1000, 1095, 1200, 1500, 1825, 2222, 2500));
    public static ArrayList<Double> fixedInterestRates=new ArrayList<>(Arrays.asList(3.00, 3.00, 3.25, 3.50, 4.00, 4.50, 4.75, 5.25, 5.75, 6.50, 7.10, 7.20, 7.25, 7.00, 7.25, 7.00, 6.75, 7.10, 6.75, 6.60, 6.50, 6.50, 6.40, 6.25));


    public FixedDepositAccount(){}

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate() {
        this.dueDate = Date.valueOf(LocalDate.now().plusDays(duration));
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getDaysHeld() {
        return daysHeld;
    }

    public void setDaysHeld(Integer daysHeld){
        this.daysHeld=daysHeld;
    }

    public Double getExpectedPayout() {
        return expectedPayout;
    }

    public void setExpectedPayout(Double expectedPayout) {
        getDaysHeld();
        this.expectedPayout=expectedPayout;
    }

    public Double getTotalPayout() {
        return totalPayout;
    }

    public void setTotalPayout(Double totalPayout) {
        this.totalPayout=totalPayout;
    }

    @Override
    public String toString() {
        return "FixedDepositAccount{" +
                "depositAmount=" + depositAmount +
                ", duration=" + duration +
                ", dueDate=" + dueDate +
                ", interestRate=" + interestRate +
                ", daysHeld=" + daysHeld +
                ", expectedPayout=" + expectedPayout +
                ", totalPayout=" + totalPayout +
                ", balance=" + balance +
                ","+
                '}';
    }

}
