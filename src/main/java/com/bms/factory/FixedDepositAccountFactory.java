package com.bms.factory;

import com.bms.model.fixeddeposit.FixedDepositAccount;
import com.bms.util.FixedDepositUtil;
import org.springframework.stereotype.Component;

@Component
public class FixedDepositAccountFactory {
    public FixedDepositAccount createFixedDepositAccount(final Double depositAmount, final Integer duration){
        if(duration<FixedDepositAccount.fixedDurations.get(0)){
            throw new IllegalArgumentException("Fixed Deposit duration can't be less than "+FixedDepositAccount.fixedDurations.get(0)+" days");
        }
        FixedDepositAccount account=new FixedDepositAccount();
        account.setDepositAmount(depositAmount);
        account.setDuration(duration);
        account.setInterestRate(FixedDepositUtil.getInterestRate(FixedDepositAccount.fixedDurations,FixedDepositAccount.fixedInterestRates,duration));
        account.setDueDate();
        account.setTotalPayout(FixedDepositUtil.calculatePayout(account.getDepositAmount(), account.getInterestRate(), account.getDuration()));
        return account;
    }
}
