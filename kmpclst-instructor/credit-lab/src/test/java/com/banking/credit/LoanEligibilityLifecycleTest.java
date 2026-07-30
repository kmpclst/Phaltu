package com.banking.credit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanEligibilityLifecycleTest {

    // Exercise focus: set up shared base-rate data once per class using @BeforeAll; tear it down with @AfterAll.

    // TODO 1: approved rate matches the class-level reference
    //   GIVEN
    //     Step 1: a reference approved rate computed once for the class
    //   WHEN
    //     Step 1: the rate is computed for a top-score applicant
    //   THEN
    //     Step 1: it matches the shared reference

    // TODO 2: income-rule rejection reason
    //   GIVEN
    //     Step 1: a good score but an unaffordable loan
    //   WHEN
    //     Step 1: the rejection reason is requested
    //   THEN
    //     Step 1: the income-based reason is returned

    // TODO 3: score reason takes priority when both rules fail
    //   GIVEN
    //     Step 1: a failing score
    //     Step 2: an unaffordable loan
    //   WHEN
    //     Step 1: the rejection reason is requested
    //   THEN
    //     Step 1: the score reason is returned over the income reason

    // TODO 4: each product keeps its own base rate
    //   GIVEN
    //     Step 1: base rates for several loan products
    //   WHEN
    //     Step 1: the rate is computed for a top-score applicant across the products
    //   THEN
    //     Step 1: each product keeps its own base rate (no premium)
}
