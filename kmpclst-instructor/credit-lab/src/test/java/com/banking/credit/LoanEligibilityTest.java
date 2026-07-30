package com.banking.credit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanEligibilityTest {

    // TODO 1: high score is accepted
    //   GIVEN
    //     Step 1: a credit score clearly above the threshold
    //   WHEN
    //     Step 1: score acceptability is checked
    //   THEN
    //     Step 1: the score is accepted

    // TODO 2: low score is rejected
    //   GIVEN
    //     Step 1: a credit score clearly below the threshold
    //   WHEN
    //     Step 1: score acceptability is checked
    //   THEN
    //     Step 1: the score is rejected

    // TODO 3: loan within the income limit is sufficient
    //   GIVEN
    //     Step 1: a loan amount and an income where the loan is well within the limit
    //   WHEN
    //     Step 1: affordability is checked
    //   THEN
    //     Step 1: the loan is deemed sufficient

    // TODO 4: loan beyond the income limit is insufficient
    //   GIVEN
    //     Step 1: a loan amount and an income where the loan exceeds the limit
    //   WHEN
    //     Step 1: affordability is checked
    //   THEN
    //     Step 1: the loan is deemed insufficient

    // TODO 5: applicant passing both rules is eligible
    //   GIVEN
    //     Step 1: an applicant who passes both the score rule and the affordability rule
    //   WHEN
    //     Step 1: overall eligibility is checked
    //   THEN
    //     Step 1: the applicant is eligible

    // TODO 6: top-band score keeps the base rate
    //   GIVEN
    //     Step 1: a top-band credit score and a base rate
    //   WHEN
    //     Step 1: the approved rate is computed
    //   THEN
    //     Step 1: the approved rate equals the base rate (no premium)

    // TODO 7: risk-band score gets a premium
    //   GIVEN
    //     Step 1: a risk-band credit score and a base rate
    //   WHEN
    //     Step 1: the approved rate is computed
    //   THEN
    //     Step 1: a premium is added on top of the base rate

    // TODO 8: eligible applicant has an empty rejection reason
    //   GIVEN
    //     Step 1: an applicant who passes all rules
    //   WHEN
    //     Step 1: the rejection reason is requested
    //   THEN
    //     Step 1: the reason is empty
}
