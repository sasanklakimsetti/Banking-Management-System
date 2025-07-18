package com.bms.model.savings;

import com.bms.model.Account;
import jakarta.persistence.*;

@Entity
@Table(name = "savings_account")
@PrimaryKeyJoinColumn(name = "accountnumber")
public class SavingsAccount extends Account {
    private String savingstype;
    private Integer minimumbalance;
    private Integer minimumbalancepenalty;
    private String cardtype;

    public SavingsAccount() {
        super();
        super.setAccountType("Savings");
    }

    public String getSavingstype() {
        return savingstype;
    }

    public void setSavingstype(String savingstype) {
        this.savingstype = savingstype;
    }

    public Integer getMinimumbalance() {
        return minimumbalance;
    }

    public void setMinimumbalance(Integer minimumbalance) {
        this.minimumbalance = minimumbalance;
    }

    public Integer getMinimumbalancepenalty() {
        return minimumbalancepenalty;
    }

    public void setMinimumbalancepenalty(Integer minimumbalancepenalty) {
        this.minimumbalancepenalty = minimumbalancepenalty;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public void withdraw(int amount){
        if(super.balance-amount<0){
            System.out.println("Sorry, you can't withdraw since the balance is not enough");
            return;
        }
        super.setBalance(super.balance-amount);
    }
}
