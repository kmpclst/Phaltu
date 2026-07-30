# 🟢 Beginner — "Basic JUnit Example"

**Concepts:** `@Test`, `assertEquals`, `assertTrue`, `assertFalse`
**Goal:** 14 tests — `LoanCalculatorTest` (6) + `LoanEligibilityTest` (8)

> Write each test using only `@Test` and the appropriate `assertXXX`. Choose your own values and work out the expected results.

## LoanCalculatorTest

### 1. EMI calculation
- **GIVEN**
  - Step 1: a standard loan scenario (choose a principal, an annual rate, and a tenure in months)
- **WHEN**
  - Step 1: the EMI is calculated for that loan
- **THEN**
  - Step 1: the result matches the EMI you worked out by hand
  - Step 2: compare the double using a delta

### 2. Processing fee
- **GIVEN**
  - Step 1: a principal and a fee percentage
- **WHEN**
  - Step 1: the processing fee is computed
- **THEN**
  - Step 1: the returned fee matches the expected value

### 3. Net disbursed amount
- **GIVEN**
  - Step 1: a principal and its already-computed processing fee
- **WHEN**
  - Step 1: the net disbursed amount is calculated
- **THEN**
  - Step 1: the fee is correctly deducted from the principal

### 4. Interest component
- **GIVEN**
  - Step 1: an outstanding balance and an annual rate
- **WHEN**
  - Step 1: the monthly interest is computed
- **THEN**
  - Step 1: the returned interest matches the expected value

### 5. Principal component
- **GIVEN**
  - Step 1: an EMI amount and its interest portion
- **WHEN**
  - Step 1: the principal portion is derived
- **THEN**
  - Step 1: it equals the remainder after subtracting interest from the EMI

### 6. Outstanding after payment
- **GIVEN**
  - Step 1: a current outstanding balance and a principal payment
- **WHEN**
  - Step 1: the payment is applied to the balance
- **THEN**
  - Step 1: the new balance reflects the deduction

## LoanEligibilityTest

### 1. High score is accepted
- **GIVEN**
  - Step 1: a credit score clearly above the threshold
- **WHEN**
  - Step 1: score acceptability is checked
- **THEN**
  - Step 1: the score is accepted

### 2. Low score is rejected
- **GIVEN**
  - Step 1: a credit score clearly below the threshold
- **WHEN**
  - Step 1: score acceptability is checked
- **THEN**
  - Step 1: the score is rejected

### 3. Loan within the income limit is sufficient
- **GIVEN**
  - Step 1: a loan amount and an income where the loan is well within the limit
- **WHEN**
  - Step 1: affordability is checked
- **THEN**
  - Step 1: the loan is deemed sufficient

### 4. Loan beyond the income limit is insufficient
- **GIVEN**
  - Step 1: a loan amount and an income where the loan exceeds the limit
- **WHEN**
  - Step 1: affordability is checked
- **THEN**
  - Step 1: the loan is deemed insufficient

### 5. Applicant passing both rules is eligible
- **GIVEN**
  - Step 1: an applicant who passes both the score rule and the affordability rule
- **WHEN**
  - Step 1: overall eligibility is checked
- **THEN**
  - Step 1: the applicant is eligible

### 6. Top-band score keeps the base rate
- **GIVEN**
  - Step 1: a top-band credit score and a base rate
- **WHEN**
  - Step 1: the approved rate is computed
- **THEN**
  - Step 1: the approved rate equals the base rate (no premium)

### 7. Risk-band score gets a premium
- **GIVEN**
  - Step 1: a risk-band credit score and a base rate
- **WHEN**
  - Step 1: the approved rate is computed
- **THEN**
  - Step 1: a premium is added on top of the base rate

### 8. Eligible applicant has an empty rejection reason
- **GIVEN**
  - Step 1: an applicant who passes all rules
- **WHEN**
  - Step 1: the rejection reason is requested
- **THEN**
  - Step 1: the reason is empty
