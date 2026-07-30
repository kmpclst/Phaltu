package com.banking.credit;

import java.util.Scanner;

public class App {

    private final Scanner sc = new Scanner(System.in);

    private String borrower = "";
    private double principal = 0;
    private double rate = 0;
    private double feePercent = 0;
    private int tenure = 0;
    private double emi = 0;
    private double outstanding = 0;
    private int emisPaid = 0;
    private boolean hasLoan = false;

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        println("=== HSBC Credit Lab ===");
        boolean running = true;
        while (running) {
            if (!hasLoan) {
                println();
                println("-- No active loan --");
                println("  1) Apply for a loan");
                println("  0) Exit");
                switch (prompt("Choose: ").trim()) {
                    case "1" -> applyForLoan();
                    case "0" -> running = false;
                    default -> println("Invalid choice.");
                }
            } else {
                println();
                println("Active loan for " + borrower + "  |  outstanding = " + outstanding
                    + "  |  EMIs paid = " + emisPaid + "/" + tenure
                    + (outstanding <= 0 ? "  [CLOSED]" : ""));
                println("  1) Pay 1 EMI");
                println("  2) Pay multiple EMIs");
                println("  3) View status");
                println("  4) Apply for a new loan");
                println("  0) Exit");
                switch (prompt("Choose: ").trim()) {
                    case "1" -> payEmis(1);
                    case "2" -> payEmis(readInt("How many EMIs? "));
                    case "3" -> showStatus();
                    case "4" -> { hasLoan = false; applyForLoan(); }
                    case "0" -> running = false;
                    default -> println("Invalid choice.");
                }
            }
        }
        println("Goodbye!");
    }

    private void applyForLoan() {
        println();
        println("--- New Loan Application ---");
        borrower = prompt("Borrower name: ").trim();
        if (borrower.isEmpty()) { println("Cancelled."); return; }

        int score = readInt("Credit score (300-850): ");
        double income = readDouble("Monthly income: ");

        println("Loan types:  1) Home (8.5%, fee 0.5%)  2) Car (10.5%, fee 1%)  3) Personal (14%, fee 2%)");
        switch (readInt("Type: ")) {
            case 1 -> { rate = 8.5;  feePercent = 0.5; }
            case 2 -> { rate = 10.5; feePercent = 1.0; }
            case 3 -> { rate = 14.0; feePercent = 2.0; }
            default -> { println("Invalid loan type."); return; }
        }

        principal = readDouble("Principal amount: ");

        String reason = LoanEligibility.rejectionReason(score, principal, income);
        if (!reason.isEmpty()) {
            println("REJECTED — " + reason);
            return;
        }

        rate = LoanEligibility.approvedRate(score, rate);
        tenure = readInt("Tenure in months: ");

        try {
            emi = LoanCalculator.calculateEmi(principal, rate, tenure);
        } catch (IllegalArgumentException e) {
            println("Could not compute EMI: " + e.getMessage());
            return;
        }

        double fee = LoanCalculator.processingFee(principal, feePercent);
        double net = LoanCalculator.netDisbursed(principal, fee);

        println("APPROVED at " + rate + "%");
        println("  EMI            = " + emi);
        println("  processing fee = " + fee);
        println("  net disbursed  = " + net);

        outstanding = principal;
        emisPaid = 0;
        hasLoan = true;
    }

    private void payEmis(int count) {
        for (int i = 0; i < count; i++) {
            if (outstanding <= 0) { println("Loan already closed."); break; }
            double interest = LoanCalculator.interestComponent(outstanding, rate);
            double principalPaid = LoanCalculator.principalComponent(emi, interest);
            if (principalPaid > outstanding) {
                principalPaid = outstanding;
            }
            double before = outstanding;
            outstanding = LoanCalculator.outstandingAfterPayment(outstanding, principalPaid);
            emisPaid++;
            println("Paid EMI #" + emisPaid + "  |  " + before + " -> " + outstanding
                + "  |  interest " + interest + "  |  principal " + principalPaid);
            if (outstanding <= 0) { println("Loan fully repaid!"); break; }
        }
    }

    private void showStatus() {
        println();
        println("--- Loan Status ---");
        println("  borrower       : " + borrower);
        println("  principal      : " + principal);
        println("  rate           : " + rate + "%");
        println("  EMI            : " + emi);
        println("  EMIs paid      : " + emisPaid + " / " + tenure);
        println("  outstanding    : " + outstanding);
        println("  status         : " + (outstanding <= 0 ? "CLOSED" : "ACTIVE"));
    }

    private String prompt(String p) {
        System.out.print(p);
        return sc.nextLine();
    }

    private int readInt(String p) {
        while (true) {
            try {
                return Integer.parseInt(prompt(p).trim());
            } catch (NumberFormatException e) {
                println("  Please enter a whole number.");
            }
        }
    }

    private double readDouble(String p) {
        while (true) {
            try {
                return Double.parseDouble(prompt(p).trim());
            } catch (NumberFormatException e) {
                println("  Please enter a valid amount.");
            }
        }
    }

    private void println() { System.out.println(); }
    private void println(String s) { System.out.println(s); }
}
