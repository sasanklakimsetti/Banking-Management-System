package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "regular_savings_account")
public class RegularSavingsAccount extends SavingsAccount{
    public RegularSavingsAccount(){
        super();
        super.setSavingstype("Regular");
        super.setCardtype("MasterCard");
        super.setMinimumbalance(4000);
        super.setMinimumbalancepenalty(400);
    }
}
