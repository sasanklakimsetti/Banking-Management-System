package com.bms.util;

import java.util.*;

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
}
