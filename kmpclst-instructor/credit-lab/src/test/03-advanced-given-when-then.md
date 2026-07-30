# 🔴 Advanced — "@BeforeAll / @AfterAll"

**Concepts:** `@BeforeAll`, `@AfterAll`, `assertThrows`
**Goal:** 10 tests — `LoanCalculatorLifecycleTest` (6) + `LoanEligibilityLifecycleTest` (4)

> Set up shared data once per class with `@BeforeAll` (static), tear it down with `@AfterAll`, and use `assertThrows` for error cases. Choose your own values and edge cases.

## LoanCalculatorLifecycleTest

### 1. EMI matches the class-level reference
- **GIVEN**
  - Step 1: a reference EMI computed once for the whole class
- **WHEN**
  - Step 1: the EMI is calculated for the same loan
- **THEN**
  - Step 1: the result matches the shared reference

### 2. Home-loan EMI
- **GIVEN**
  - Step 1: a long-term, low-rate home-loan scenario
- **WHEN**
  - Step 1: the EMI is calculated
- **THEN**
  - Step 1: it matches the expected value

### 3. Non-positive principal throws
- **GIVEN**
  - Step 1: an invalid (non-positive) principal
- **WHEN**
  - Step 1: the EMI is calculated
- **THEN**
  - Step 1: an exception is thrown

### 4. Non-positive term throws
- **GIVEN**
  - Step 1: an invalid (non-positive) term
- **WHEN**
  - Step 1: the EMI is calculated
- **THEN**
  - Step 1: an exception is thrown

### 5. Negative rate throws
- **GIVEN**
  - Step 1: an invalid (negative) rate
- **WHEN**
  - Step 1: the EMI is calculated
- **THEN**
  - Step 1: an exception is thrown

### 6. Exception carries the right message
- **GIVEN**
  - Step 1: an invalid (non-positive) principal
- **WHEN**
  - Step 1: the thrown exception is captured
- **THEN**
  - Step 1: its message is correct

## LoanEligibilityLifecycleTest

### 1. Approved rate matches the class-level reference
- **GIVEN**
  - Step 1: a reference approved rate computed once for the class
- **WHEN**
  - Step 1: the rate is computed for a top-score applicant
- **THEN**
  - Step 1: it matches the shared reference

### 2. Income-rule rejection reason
- **GIVEN**
  - Step 1: a good score but an unaffordable loan
- **WHEN**
  - Step 1: the rejection reason is requested
- **THEN**
  - Step 1: the income-based reason is returned

### 3. Score reason takes priority when both rules fail
- **GIVEN**
  - Step 1: a failing score
  - Step 2: an unaffordable loan
- **WHEN**
  - Step 1: the rejection reason is requested
- **THEN**
  - Step 1: the score reason is returned over the income reason

### 4. Each product keeps its own base rate
- **GIVEN**
  - Step 1: base rates for several loan products
- **WHEN**
  - Step 1: the rate is computed for a top-score applicant across the products
- **THEN**
  - Step 1: each product keeps its own base rate (no premium)
