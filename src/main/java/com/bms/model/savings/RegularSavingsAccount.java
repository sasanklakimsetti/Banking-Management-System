package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "regular_savings_accounts")
public class RegularSavingsAccount extends SavingsAccount{
    public RegularSavingsAccount(){
        super(4000.0);
        super.setSavingsType("Regular");
        super.setCardType("MasterCard");
        super.setMinimumBalance(4000);
        super.setMinimumBalancePenalty(400);
    }
}
