# credit-lab — JUnit 5 Test Lab

A hands-on lab for learning JUnit 5, built around a small banking **credit / loan** domain.
Every feature in the accompanying slides is exercised across three difficulty tiers.

> The test classes are intentionally left as **TODOs**. Each test is described in
> **GIVEN / WHEN / THEN + numbered steps** form. Your job is to implement each test
> by following those steps — choosing your own values, method names, and assertions.

---

## Project structure

```
credit-lab/
├── pom.xml
└── src/
    ├── main/java/com/banking/credit/
    │   ├── LoanCalculator.java      ← the math (EMI, fees, interest, balances)
    │   ├── LoanEligibility.java     ← the rules (score, income, rate, rejection)
    │   └── App.java
    └── test/
        ├── README.md                         ← you are here
        ├── 01-beginner-given-when-then.md    ← guide for 🟢 Tier 1
        ├── 02-intermediate-given-when-then.md← guide for 🟡 Tier 2
        ├── 03-advanced-given-when-then.md    ← guide for 🔴 Tier 3
        └── java/com/banking/credit/
            ├── LoanCalculatorTest.java           🟢
            ├── LoanEligibilityTest.java          🟢
            ├── LoanCalculatorFixtureTest.java    🟡
            ├── LoanEligibilityFixtureTest.java   🟡
            ├── LoanCalculatorLifecycleTest.java  🔴
            └── LoanEligibilityLifecycleTest.java 🔴
```

---

## Complexity hierarchy

The lab is divided into **3 tiers**. Each tier introduces new JUnit 5 concepts and
builds strictly on the previous one — no concept is used before its tier teaches it.

### 🟢 Tier 1 — Beginner · "Basic JUnit Example"
**Concepts:** `@Test`, `assertEquals`, `assertTrue`, `assertFalse`
**Tests:** 14 (`LoanCalculatorTest` 6 + `LoanEligibilityTest` 8)

Each test is self-contained: one input → one call → one assertion. No shared state.

### 🟡 Tier 2 — Intermediate · "Fixture Example"
**Concepts:** `@BeforeEach`, `@AfterEach` (+ boundary-value testing)
**Tests:** 13 (`LoanCalculatorFixtureTest` 7 + `LoanEligibilityFixtureTest` 6)

Tests now share **instance state** via a fixture — set up before each test, torn down
after. You also test **boundaries** (a value *at* a threshold vs. *just below* it).

### 🔴 Tier 3 — Advanced · "@BeforeAll / @AfterAll"
**Concepts:** `@BeforeAll`, `@AfterAll` (`static`, per-class), `assertThrows`
**Tests:** 10 (`LoanCalculatorLifecycleTest` 6 + `LoanEligibilityLifecycleTest` 4)

Shared state lives at the **class level** (computed once). You also test **error
paths** — verifying that invalid input throws, and that the exception *message* is
correct.

| Skill introduced | Tier |
|---|---|
| `@Test` + `assertXXX` | 🟢 1 |
| Shared setup/teardown per test | 🟡 2 |
| Boundary-value thinking | 🟡 2 |
| Shared setup/teardown per **class** (`static`) | 🔴 3 |
| Exception testing + message checks | 🔴 3 |

**Total: 37 tests across 3 tiers.**

---

## How the complexity scales

```
Tier 1 (Beginner)        Tier 2 (Intermediate)        Tier 3 (Advanced)
─────────────────        ──────────────────────       ──────────────────
@Test only               + @BeforeEach/AfterEach      + @BeforeAll/AfterAll
single call              shared instance state        shared static state
happy-path values        boundary edges               error paths (exceptions)
one assertion            multiple asserts per test    exception + message checks

Scope:  per-test         Scope:  per-instance         Scope:  per-class
  14 tests                 13 tests                    10 tests
```

---

## How to use this lab

1. **Pick a tier** (start at 🟢 Tier 1 if you're new to JUnit).
2. **Read the matching `0X-...-given-when-then.md` guide** for the GIVEN/WHEN/THEN
   breakdown of every test.
3. **Open the corresponding test class** and implement each `TODO N` by following
   its GIVEN/WHEN/THEN steps. Choose your own values and work out the expected
   results.
4. **Run the tests** (below) and make them pass.

---

## Running the tests

```bash
mvn test                       # run all tests
mvn -Dtest=LoanCalculatorTest test   # run a single class
```

> The TODO stubs compile, but until you implement them they pass *trivially*
> (an empty `@Test` method succeeds). As you fill them in with real assertions,
> they begin to actually verify behaviour.

---

## What you're testing

| Class | Responsibility |
|---|---|
| `LoanCalculator` | EMI, processing fee, net disbursed amount, monthly interest, principal component, outstanding balance |
| `LoanEligibility` | credit-score acceptability, income-based affordability, overall eligibility, approved rate (with risk premium), rejection reason |

See `src/main/java/com/banking/credit/` for the implementations under test.
