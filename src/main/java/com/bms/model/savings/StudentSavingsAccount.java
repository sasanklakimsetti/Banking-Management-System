package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;

@Entity
@Table(name = "student_savings_accounts")
public class StudentSavingsAccount extends SavingsAccount{
    public StudentSavingsAccount(){
        super(500.0);
        super.setSavingsType("Student");
        super.setMinimumBalance(500);
        super.setMinimumBalancePenalty(50);
        super.setCardType("RuPay");
    }
}
