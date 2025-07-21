package com.bms.factory;

import com.bms.model.loan.CarLoanAccount;
import com.bms.model.loan.HouseLoanAccount;
import com.bms.model.loan.PersonalLoanAccount;
import com.bms.model.loan.StudentLoanAccount;
import com.bms.util.LoanUtil;
import org.springframework.stereotype.Component;

@Component
public class LoanAccountFactory {
    public CarLoanAccount createCarLoanAccount(final Double loanAmount, final String collateralType, final Double collateralValue, final Integer durationInDays){
        if(loanAmount<600000){
            throw new IllegalArgumentException("Car Loan Amount must be greater than 6 lakhs");
        }
        if(durationInDays<365){
            throw new IllegalArgumentException("Car Loan Duration must be greater than one year");
        }
        CarLoanAccount account=new CarLoanAccount();
        account.setLoanAmount(loanAmount);
        account.setCollateralType(collateralType);
        account.setCollateralValue(collateralValue);
        account.setDurationInDays(durationInDays);
        account.setEmiAmount(LoanUtil.calculateEMI(loanAmount,account.getInterestRate(),durationInDays));
        account.setBalance(-loanAmount);
        return account;
    }
    public HouseLoanAccount createHouseLoanAccount(final Double loanAmount, final String collateralType, final Double collateralValue, final Integer durationInDays){
        if(loanAmount<1000000){
            throw new IllegalArgumentException("Car Loan Amount must be greater than 10 lakhs");
        }
        if(durationInDays<1825){
            throw new IllegalArgumentException("House Loan Duration must be greater than 5 years");
        }
        HouseLoanAccount account=new HouseLoanAccount();
        account.setLoanAmount(loanAmount);
        account.setCollateralType(collateralType);
        account.setCollateralValue(collateralValue);
        account.setDurationInDays(durationInDays);
        account.setEmiAmount(LoanUtil.calculateEMI(loanAmount,account.getInterestRate(),durationInDays));
        account.setBalance(-loanAmount);
        return account;
    }
    public PersonalLoanAccount createPersonalLoanAccount(final Double loanAmount, final String collateralType, final Double collateralValue, final Integer durationInDays){
        if(loanAmount>600000){
            throw new IllegalArgumentException("Car Loan Amount must be  6 lakhs or less");
        }
        if(durationInDays>1825){
            throw new IllegalArgumentException("Personal Loan Duration must be 5 years or less");
        }
        PersonalLoanAccount account=new PersonalLoanAccount();
        account.setLoanAmount(loanAmount);
        account.setCollateralType(collateralType);
        account.setCollateralValue(collateralValue);
        account.setDurationInDays(durationInDays);
        account.setEmiAmount(LoanUtil.calculateEMI(loanAmount,account.getInterestRate(),durationInDays));
        account.setBalance(-loanAmount);
        return account;
    }
    public StudentLoanAccount createStudentLoanAccount(final Double loanAmount, final String collateralType, final Double collateralValue, final Integer durationInDays){
        if(durationInDays>3650){
            throw new IllegalArgumentException("Student Loan Duration must be ten years or less");
        }
        StudentLoanAccount account=new StudentLoanAccount();
        account.setLoanAmount(loanAmount);
        account.setCollateralType(collateralType);
        account.setCollateralValue(collateralValue);
        account.setDurationInDays(durationInDays);
        account.setEmiAmount(LoanUtil.calculateEMI(loanAmount,account.getInterestRate(),durationInDays));
        account.setBalance(-loanAmount);
        return account;
    }
}
