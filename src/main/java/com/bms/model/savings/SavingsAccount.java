package com.bms.model.savings;

import com.bms.model.Account;
import jakarta.persistence.*;

@Entity
@Table(name = "savings_accounts")
@PrimaryKeyJoinColumn(name = "accountNumber")
public class SavingsAccount extends Account {
    private String savingsType;
    private Integer minimumBalance;
    private Integer minimumBalancePenalty;
    private String cardType;

    public SavingsAccount(Double balance){
        super.setBalance(balance);
    }

    public SavingsAccount() {
        super();
        super.setAccountType("Savings");
    }

    public String getSavingsType() {
        return savingsType;
    }

    public void setSavingsType(String savingsType) {
        this.savingsType = savingsType;
    }

    public Integer getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Integer minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Integer getMinimumBalancePenalty() {
        return minimumBalancePenalty;
    }

    public void setMinimumBalancePenalty(Integer minimumBalancePenalty) {
        this.minimumBalancePenalty = minimumBalancePenalty;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void withdraw(int amount){
        if(super.balance-amount<0){
            System.out.println("Sorry, you can't withdraw since the balance is not enough");
            return;
        }
        super.setBalance(super.balance-amount);
    }
}
