package com.banking.credit;

public class LoanCalculator {

    public static double calculateEmi(double principal, double annualRatePct, int months) {
        if (principal <= 0) {
            throw new IllegalArgumentException("principal must be positive");
        }
        if (months <= 0) {
            throw new IllegalArgumentException("months must be positive");
        }
        if (annualRatePct < 0) {
            throw new IllegalArgumentException("rate must not be negative");
        }

        double monthlyRate = annualRatePct / 100.0 / 12.0;
        if (monthlyRate == 0) {
            return round2(principal / months);
        }
        double factor = Math.pow(1 + monthlyRate, months);
        return round2((principal * monthlyRate * factor) / (factor - 1));
    }

    public static double processingFee(double principal, double feePercent) {
        return round2(principal * feePercent / 100.0);
    }

    public static double netDisbursed(double principal, double processingFee) {
        return round2(principal - processingFee);
    }

    public static double interestComponent(double outstanding, double annualRatePct) {
        return round2(outstanding * annualRatePct / 100.0 / 12.0);
    }

    public static double principalComponent(double emi, double interestComponent) {
        return round2(emi - interestComponent);
    }

    public static double outstandingAfterPayment(double outstanding, double principalComponent) {
        return round2(outstanding - principalComponent);
    }

    private static double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
