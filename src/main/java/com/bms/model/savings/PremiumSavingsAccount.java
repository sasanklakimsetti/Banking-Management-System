package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium_savings_account")
public class PremiumSavingsAccount extends SavingsAccount{
    public PremiumSavingsAccount(){
        super();
        super.setSavingstype("Premium");
        super.setCardtype("American Express");
        super.setMinimumbalance(10000);
        super.setMinimumbalancepenalty(1000);
    }
}
