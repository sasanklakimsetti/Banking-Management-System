package com.bms.factory;

import com.bms.model.savings.PremiumSavingsAccount;
import com.bms.model.savings.RegularSavingsAccount;
import com.bms.model.savings.SavingsAccount;
import com.bms.model.savings.StudentSavingsAccount;
import org.springframework.stereotype.Component;

@Component
public class SavingsAccountFactory {
    public SavingsAccount createSavingsAccount(String type){
        switch (type){
            case "Basic":
                return new SavingsAccount();
            case "Regular":
                return new RegularSavingsAccount();
            case "Student":
                return new StudentSavingsAccount();
            case "Premium":
                return new PremiumSavingsAccount();
            default:
                throw new IllegalArgumentException("Unsupported Savings Account type: "+type);
        }
    }
}
