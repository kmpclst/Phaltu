package com.banking.credit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanEligibilityFixtureTest {

    // Exercise focus: share common applicant values across tests using @BeforeEach; reset them with @AfterEach.

    // TODO 1: score boundary behaviour
    //   GIVEN
    //     Step 1: the score cutoff value
    //   WHEN
    //     Step 1: a score just at the cutoff is checked
    //     Step 2: a score just below the cutoff is checked
    //   THEN
    //     Step 1: the boundary score is accepted
    //     Step 2: the below-boundary score is rejected

    // TODO 2: income-limit boundary behaviour
    //   GIVEN
    //     Step 1: the income-based loan limit
    //   WHEN
    //     Step 1: a loan exactly at the limit is checked
    //     Step 2: a loan just over the limit is checked
    //   THEN
    //     Step 1: the at-limit loan is sufficient
    //     Step 2: the over-limit loan is insufficient

    // TODO 3: premium-threshold boundary behaviour
    //   GIVEN
    //     Step 1: the premium threshold and a base rate
    //   WHEN
    //     Step 1: a score just at the threshold is checked
    //     Step 2: a score just below the threshold is checked
    //   THEN
    //     Step 1: the at-threshold score gets the base rate
    //     Step 2: the below-threshold score gets the premium rate

    // TODO 4: good score but oversized loan
    //   GIVEN
    //     Step 1: a good credit score
    //     Step 2: an oversized loan for the income
    //   WHEN
    //     Step 1: eligibility is checked
    //   THEN
    //     Step 1: the applicant is rejected (affordability fails)

    // TODO 5: bad score but affordable loan
    //   GIVEN
    //     Step 1: a bad credit score
    //     Step 2: an affordable loan
    //   WHEN
    //     Step 1: eligibility is checked
    //   THEN
    //     Step 1: the applicant is rejected (score fails)

    // TODO 6: rejection reason for a low score
    //   GIVEN
    //     Step 1: a score below the cutoff
    //   WHEN
    //     Step 1: the rejection reason is requested
    //   THEN
    //     Step 1: the score-based reason is returned
}
