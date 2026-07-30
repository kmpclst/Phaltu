package com.banking.credit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorLifecycleTest {

    // Exercise focus: set up shared reference data once per class using @BeforeAll; tear it down with @AfterAll.

    // TODO 1: EMI matches the class-level reference
    //   GIVEN
    //     Step 1: a reference EMI computed once for the whole class
    //   WHEN
    //     Step 1: the EMI is calculated for the same loan
    //   THEN
    //     Step 1: the result matches the shared reference

    // TODO 2: home-loan EMI
    //   GIVEN
    //     Step 1: a long-term, low-rate home-loan scenario
    //   WHEN
    //     Step 1: the EMI is calculated
    //   THEN
    //     Step 1: it matches the expected value

    // TODO 3: non-positive principal throws
    //   GIVEN
    //     Step 1: an invalid (non-positive) principal
    //   WHEN
    //     Step 1: the EMI is calculated
    //   THEN
    //     Step 1: an exception is thrown

    // TODO 4: non-positive term throws
    //   GIVEN
    //     Step 1: an invalid (non-positive) term
    //   WHEN
    //     Step 1: the EMI is calculated
    //   THEN
    //     Step 1: an exception is thrown

    // TODO 5: negative rate throws
    //   GIVEN
    //     Step 1: an invalid (negative) rate
    //   WHEN
    //     Step 1: the EMI is calculated
    //   THEN
    //     Step 1: an exception is thrown

    // TODO 6: exception carries the right message
    //   GIVEN
    //     Step 1: an invalid (non-positive) principal
    //   WHEN
    //     Step 1: the thrown exception is captured
    //   THEN
    //     Step 1: its message is correct
}
