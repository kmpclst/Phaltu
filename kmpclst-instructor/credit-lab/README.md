# credit-lab

An interactive command-line **loan management** application for the HSBC Credit Lab,
built in plain Java. Apply for a loan, get it evaluated against credit rules, and
repay it EMI-by-EMI while watching the outstanding balance decline.

```
=== HSBC Credit Lab ===

-- No active loan --
  1) Apply for a loan
  0) Exit
```

---

## Features

- **Loan application** — enter borrower details, credit score, income, principal and tenure.
- **Loan products** with preset rates and processing fees:
  | Type | Rate | Fee |
  |------|------|-----|
  | Home | 8.5% | 0.5% |
  | Car | 10.5% | 1.0% |
  | Personal | 14.0% | 2.0% |
- **Eligibility checks** — rejected upfront if the credit score or income rules fail, with a human-readable reason.
- **Risk-based pricing** — a premium is added to the rate for lower credit-score bands.
- **EMI calculation** — standard amortising EMI, plus processing fee and net disbursed amount.
- **Repayment** — pay one or many EMIs; each payment splits into interest and principal and reduces the outstanding balance.
- **Status view** — see borrower, principal, rate, EMI, EMIs paid, outstanding, and ACTIVE/CLOSED state.

---

## Domain model

The business logic lives in two stateless classes (all methods are `static`):

### `LoanCalculator` — the math
| Method | Does |
|--------|------|
| `calculateEmi(principal, annualRatePct, months)` | Amortising EMI (throws on invalid input) |
| `processingFee(principal, feePercent)` | Upfront fee |
| `netDisbursed(principal, processingFee)` | Amount actually received |
| `interestComponent(outstanding, annualRatePct)` | Monthly interest on the current balance |
| `principalComponent(emi, interestComponent)` | Principal part of an EMI |
| `outstandingAfterPayment(outstanding, principalComponent)` | New balance after a payment |

### `LoanEligibility` — the rules
| Method | Does |
|--------|------|
| `isCreditScoreAcceptable(score)` | `score >= 600` |
| `isIncomeSufficient(principal, income)` | `principal <= income * 60` |
| `isEligible(score, principal, income)` | Both rules combined |
| `approvedRate(score, baseRate)` | Base rate for `score >= 750`, else `+ 2.0` premium |
| `rejectionReason(score, principal, income)` | Empty if eligible; else the failing rule (score checked first) |

### `App` — the CLI
A menu-driven `Scanner`-based interface (`App.java`) that wires the two domain
classes into an interactive session.

---

## Tech stack

- **Java 21**
- **Maven** (build + dependency management)
- **JUnit 5** (`5.10.2`, test scope)

---

## Build & run

```bash
mvn clean package          # compile + run tests
mvn exec:java              # launch the interactive CLI
```

> The `exec-maven-plugin` is configured in `pom.xml` for `mvn exec:java`.

---

## Project structure

```
credit-lab/
├── pom.xml
└── src/
    ├── main/java/com/banking/credit/
    │   ├── App.java                 ← interactive CLI entry point
    │   ├── LoanCalculator.java      ← loan math
    │   └── LoanEligibility.java     ← eligibility & pricing rules
    └── test/
        ├── README.md                ← full guide to the JUnit 5 test lab
        ├── 01-beginner-given-when-then.md
        ├── 02-intermediate-given-when-then.md
        ├── 03-advanced-given-when-then.md
        └── java/com/banking/credit/  ← 6 test classes (TODO-driven)
```

---

## Testing

The project ships a **3-tier JUnit 5 lab** (37 tests) that exercises every method
above, organised by increasing complexity:

| Tier | Concepts | Tests |
|------|----------|-------|
| 🟢 Beginner | `@Test`, `assertXXX` | 14 |
| 🟡 Intermediate | `@BeforeEach`, `@AfterEach`, boundaries | 13 |
| 🔴 Advanced | `@BeforeAll`, `@AfterAll`, `assertThrows` | 10 |

```bash
mvn test                          # run all tests
mvn -Dtest=LoanCalculatorTest test   # run one class
```

See [`src/test/README.md`](src/test/README.md) for the full test-lab guide.
