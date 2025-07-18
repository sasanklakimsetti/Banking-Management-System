package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium_savings_accounts")
public class PremiumSavingsAccount extends SavingsAccount{
    public PremiumSavingsAccount(){
        super(10000.0);
        super.setSavingsType("Premium");
        super.setCardType("American Express");
        super.setMinimumBalance(10000);
        super.setMinimumBalancePenalty(1000);
    }
}
