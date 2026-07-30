package com.banking.credit;

public class LoanEligibility {

    public static boolean isCreditScoreAcceptable(int creditScore) {
        return creditScore >= 600;
    }

    public static boolean isIncomeSufficient(double principal, double monthlyIncome) {
        return principal <= monthlyIncome * 60;
    }

    public static boolean isEligible(int creditScore, double principal, double monthlyIncome) {
        return creditScore >= 600 && principal <= monthlyIncome * 60;
    }

    public static double approvedRate(int creditScore, double baseRate) {
        if (creditScore >= 750) {
            return baseRate;
        }
        return baseRate + 2.0;
    }

    public static String rejectionReason(int creditScore, double principal, double monthlyIncome) {
        if (creditScore < 600) {
            return "credit score below 600";
        }
        if (principal > monthlyIncome * 60) {
            return "loan too large for income";
        }
        return "";
    }
}
