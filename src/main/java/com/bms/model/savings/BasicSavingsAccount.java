package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "basic_savings_accounts")
public class BasicSavingsAccount extends SavingsAccount{
    public BasicSavingsAccount(){
        super(1000.0);
        super.setSavingsType("Basic");
        super.setCardType("Visa");
        super.setMinimumBalance(1000);
        super.setMinimumBalancePenalty(100);
    }
}
