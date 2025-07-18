package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "basic_savings_account")
public class BasicSavingsAccount extends SavingsAccount{
    public BasicSavingsAccount(){
        super();
        super.setSavingstype("Basic");
        super.setCardtype("Visa");
        super.setMinimumbalance(1000);
        super.setMinimumbalancepenalty(100);
    }
}
