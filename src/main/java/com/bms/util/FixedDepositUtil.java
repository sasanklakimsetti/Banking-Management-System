package com.bms.util;

import com.sun.jdi.DoubleValue;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.sql.Date;

public class FixedDepositUtil {
    public static int findLowerBound(ArrayList<Integer> durations, int target){
        int low=0, high=durations.size()-1;
        int result=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(durations.get(mid)<=target){
                result=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return result;
    }

    public static double getInterestRate(ArrayList<Integer> durations, ArrayList<Double>interestRates, int duration){
        int index=durations.indexOf(duration);
        if(index!=-1) return interestRates.get(index);

        int lowerBoundIndex=findLowerBound(durations, duration);
        if(lowerBoundIndex==-1) throw new IllegalArgumentException("Duration is below the minimum fixed duration.");
        return interestRates.get(lowerBoundIndex);
    }

    public static int calculateDaysHeld(Date creationDate) {
        LocalDate presentDate = LocalDate.now();
        LocalDate createdDate = creationDate.toLocalDate();
        return Math.toIntExact(ChronoUnit.DAYS.between(createdDate, presentDate));
    }

    public static double calculatePayout(double depositAmount, double interestRate, int durationInDays) {
        int time = durationInDays / 365;
        int n = 4; // quarterly compounding
        double r = interestRate / 100.0;
        return depositAmount + (depositAmount * Math.pow(1 + (r / n), n * time));
    }

    public static Date calculateDueDate(int durationInDays) {
        return Date.valueOf(LocalDate.now().plusDays(durationInDays));
    }
}
