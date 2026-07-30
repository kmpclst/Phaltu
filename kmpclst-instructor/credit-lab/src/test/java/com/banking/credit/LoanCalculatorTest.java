package com.banking.credit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorTest {

    // TODO 1: EMI calculation
    //   GIVEN
    //     Step 1: a standard loan scenario (choose a principal, an annual rate, and a tenure in months)
    //   WHEN
    //     Step 1: the EMI is calculated for that loan
    //   THEN
    //     Step 1: the result matches the EMI you worked out by hand
    //     Step 2: compare the double using a delta

    // TODO 2: processing fee
    //   GIVEN
    //     Step 1: a principal and a fee percentage
    //   WHEN
    //     Step 1: the processing fee is computed
    //   THEN
    //     Step 1: the returned fee matches the expected value

    // TODO 3: net disbursed amount
    //   GIVEN
    //     Step 1: a principal and its already-computed processing fee
    //   WHEN
    //     Step 1: the net disbursed amount is calculated
    //   THEN
    //     Step 1: the fee is correctly deducted from the principal

    // TODO 4: interest component
    //   GIVEN
    //     Step 1: an outstanding balance and an annual rate
    //   WHEN
    //     Step 1: the monthly interest is computed
    //   THEN
    //     Step 1: the returned interest matches the expected value

    // TODO 5: principal component
    //   GIVEN
    //     Step 1: an EMI amount and its interest portion
    //   WHEN
    //     Step 1: the principal portion is derived
    //   THEN
    //     Step 1: it equals the remainder after subtracting interest from the EMI

    // TODO 6: outstanding after payment
    //   GIVEN
    //     Step 1: a current outstanding balance and a principal payment
    //   WHEN
    //     Step 1: the payment is applied to the balance
    //   THEN
    //     Step 1: the new balance reflects the deduction
}
