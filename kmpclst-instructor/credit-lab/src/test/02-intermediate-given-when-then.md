# 🟡 Intermediate — "Fixture Example"

**Concepts:** `@BeforeEach`, `@AfterEach`
**Goal:** 13 tests — `LoanCalculatorFixtureTest` (7) + `LoanEligibilityFixtureTest` (6)

> Introduce shared fixture state. Set it up in `@BeforeEach`, tear it down in `@AfterEach`, and reuse it across tests. Choose your own values and boundaries.

## LoanCalculatorFixtureTest

### 1. EMI from the fixture
- **GIVEN**
  - Step 1: a loan fixture initialised by the setup method
- **WHEN**
  - Step 1: the EMI is calculated from the fixture fields
- **THEN**
  - Step 1: it matches the expected value

### 2. Monthly interest from the fixture
- **GIVEN**
  - Step 1: a loan fixture initialised by the setup method
- **WHEN**
  - Step 1: the monthly interest is computed from the fixture fields
- **THEN**
  - Step 1: it matches the expected value

### 3. Processing fee and net amount from the fixture
- **GIVEN**
  - Step 1: a loan fixture initialised by the setup method
- **WHEN**
  - Step 1: the processing fee is computed
  - Step 2: the net disbursed amount is computed from that fee
- **THEN**
  - Step 1: both the fee and net values are correct

### 4. Zero-interest loan uses simple division
- **GIVEN**
  - Step 1: a zero-interest loan
- **WHEN**
  - Step 1: the EMI is calculated
- **THEN**
  - Step 1: the simple-division branch (principal / months) is used

### 5. Interest on a declining balance
- **GIVEN**
  - Step 1: a balance that has declined after a payment
- **WHEN**
  - Step 1: the interest is recomputed on the new balance
- **THEN**
  - Step 1: it reflects the reduced balance

### 6. Final payment zeroes the balance
- **GIVEN**
  - Step 1: an outstanding balance equal to the final payment
- **WHEN**
  - Step 1: the payment is applied
- **THEN**
  - Step 1: the balance becomes zero

### 7. Prove the fixture was initialised
- **GIVEN**
  - Step 1: the setup method should run before every test
- **WHEN**
  - Step 1: a fixture field is inspected inside a test
- **THEN**
  - Step 1: it holds the initialised value (proves @BeforeEach ran)

## LoanEligibilityFixtureTest

### 1. Score boundary behaviour
- **GIVEN**
  - Step 1: the score cutoff value
- **WHEN**
  - Step 1: a score just at the cutoff is checked
  - Step 2: a score just below the cutoff is checked
- **THEN**
  - Step 1: the boundary score is accepted
  - Step 2: the below-boundary score is rejected

### 2. Income-limit boundary behaviour
- **GIVEN**
  - Step 1: the income-based loan limit
- **WHEN**
  - Step 1: a loan exactly at the limit is checked
  - Step 2: a loan just over the limit is checked
- **THEN**
  - Step 1: the at-limit loan is sufficient
  - Step 2: the over-limit loan is insufficient

### 3. Premium-threshold boundary behaviour
- **GIVEN**
  - Step 1: the premium threshold and a base rate
- **WHEN**
  - Step 1: a score just at the threshold is checked
  - Step 2: a score just below the threshold is checked
- **THEN**
  - Step 1: the at-threshold score gets the base rate
  - Step 2: the below-threshold score gets the premium rate

### 4. Good score but oversized loan
- **GIVEN**
  - Step 1: a good credit score
  - Step 2: an oversized loan for the income
- **WHEN**
  - Step 1: eligibility is checked
- **THEN**
  - Step 1: the applicant is rejected (affordability fails)

### 5. Bad score but affordable loan
- **GIVEN**
  - Step 1: a bad credit score
  - Step 2: an affordable loan
- **WHEN**
  - Step 1: eligibility is checked
- **THEN**
  - Step 1: the applicant is rejected (score fails)

### 6. Rejection reason for a low score
- **GIVEN**
  - Step 1: a score below the cutoff
- **WHEN**
  - Step 1: the rejection reason is requested
- **THEN**
  - Step 1: the score-based reason is returned
