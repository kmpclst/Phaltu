package com.banking.credit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorFixtureTest {

    // Exercise focus: share common loan values across tests using @BeforeEach; reset them with @AfterEach.

    // Fixture fields shared across all tests
    double principal;
    double annualRatePct;
    int months;

    @BeforeEach
    void setUp() {
        principal = 100_000.0;
        annualRatePct = 12.0;
        months = 12;
    }

    @AfterEach
    void tearDown() {
        principal = 0;
        annualRatePct = 0;
        months = 0;
    }

    // TODO 1: EMI from the fixture
    //   GIVEN
    //     Step 1: a loan fixture initialised by the setup method
    //   WHEN
    //     Step 1: the EMI is calculated from the fixture fields
    //   THEN
    //     Step 1: it matches the expected value
    @Test
    void emiFromFixture() {
        // GIVEN – fixture fields initialised by setUp()

        // WHEN
        double emi = LoanCalculator.calculateEmi(principal, annualRatePct, months);

        // THEN
        assertEquals(8884.88, emi, "EMI for 100 000 @ 12 % over 12 months should be 8884.88");
    }

    // TODO 2: monthly interest from the fixture
    //   GIVEN
    //     Step 1: a loan fixture initialised by the setup method
    //   WHEN
    //     Step 1: the monthly interest is computed from the fixture fields
    //   THEN
    //     Step 1: it matches the expected value
    @Test
    void monthlyInterestFromFixture() {
        // GIVEN – fixture fields initialised by setUp()

        // WHEN
        double interest = LoanCalculator.interestComponent(principal, annualRatePct);

        // THEN
        assertEquals(1000.0, interest, "Monthly interest for 100 000 @ 12 % should be 1000.0");
    }

    // TODO 3: processing fee and net amount from the fixture
    //   GIVEN
    //     Step 1: a loan fixture initialised by the setup method
    //   WHEN
    //     Step 1: the processing fee is computed
    //     Step 2: the net disbursed amount is computed from that fee
    //   THEN
    //     Step 1: both the fee and net values are correct

    // TODO 4: zero-interest loan uses simple division
    //   GIVEN
    //     Step 1: a zero-interest loan
    //   WHEN
    //     Step 1: the EMI is calculated
    //   THEN
    //     Step 1: the simple-division branch (principal / months) is used

    // TODO 5: interest on a declining balance
    //   GIVEN
    //     Step 1: a balance that has declined after a payment
    //   WHEN
    //     Step 1: the interest is recomputed on the new balance
    //   THEN
    //     Step 1: it reflects the reduced balance

    // TODO 6: final payment zeroes the balance
    //   GIVEN
    //     Step 1: an outstanding balance equal to the final payment
    //   WHEN
    //     Step 1: the payment is applied
    //   THEN
    //     Step 1: the balance becomes zero

    // TODO 7: prove the fixture was initialised
    //   GIVEN
    //     Step 1: the setup method should run before every test
    //   WHEN
    //     Step 1: a fixture field is inspected inside a test
    //   THEN
    //     Step 1: it holds the initialised value (proves @BeforeEach ran)
}
