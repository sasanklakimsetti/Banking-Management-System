package com.bms.model.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;

@Entity
@Table(name = "student_savings_account")
public class StudentSavingsAccount extends SavingsAccount{
    public StudentSavingsAccount(){
        super();
        super.setSavingstype("Student");
        super.setMinimumbalance(500);
        super.setMinimumbalancepenalty(50);
        super.setCardtype("RuPay");
    }
}
