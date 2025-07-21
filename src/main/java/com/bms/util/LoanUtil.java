package com.bms.util;

public class LoanUtil {
    public static double calculateEMI(double loanAmount, double interestRate, int durationInDays) {
        int numberOfMonths = durationInDays / 30;
        double monthlyInterestRate = interestRate / 100 / 12;

        if (monthlyInterestRate == 0 || numberOfMonths == 0) return loanAmount / numberOfMonths;

        return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) /
                (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }
}
