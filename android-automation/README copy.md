# Android Automation Testing - MyDemoApp

This project is an Android automation testing framework built using Appium, Selenium, Cucumber, and JUnit.

The automation simulates a real user flow in a mobile shopping application, including login, product selection, checkout process, and product sorting validation.

---

## Tech Stack

- Java 17
- Appium Java Client 8.6.0
- Selenium 4.15.0
- Cucumber (BDD approach)
- JUnit 4.13.2
- Maven

--- 

## Application Under Test

This automation is built for:

MyDemoApp (Android sample application used for UI automation practice)

---

## Test Scenario

### End-to-End User Flow

The scenario covers a full user journey:

1. Open product page
2. Login via menu
3. Select product (Sauce Labs Backpack)
4. Configure product and add to cart
5. Open cart and proceed to checkout
6. Complete checkout process
7. Return to product page
8. Sort product by name (Z → A)
9. Sort product by price (low → high)
10. Validate product list is displayed correctly

---

## Feature File

```gherkin
Feature: Android MyDemoApp Flow

Scenario: Login, buy product, checkout, and sort product
  Given user is on product page
  When user login from menu
  And user selects product Sauce Labs Backpack
  And user configures product and add to cart
  And user opens cart and checkout
  And user completes checkout process
  And user returns to product page
  And user sorts product by name descending
  And user sorts product by price ascending
  Then product list should be displayed
```

---

## Project Structure

```text
src/test
├── java
│   ├── hooks
│   │   └── Hooks.java
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   ├── runners
│   │   └── TestRunner.java
│   ├── stepdefinitions
│   │   └── AndroidSteps.java
│   └── utils
│       └── DriverManager.java
└── resources
    └── features
        └── android.feature
```

---

## Framework Design

This framework follows Page Object Model (POM) and Cucumber BDD approach.

### Key Design Principles:

- Page classes handle all UI interactions (Login, Product, Cart, Checkout)
- Step Definitions contain business flow logic mapped from Gherkin steps
- Hooks handle driver setup and teardown
- DriverManager manages Appium session lifecycle

This separation helps improve maintainability and scalability when test cases grow.

---

## How to Run

### 1. Install dependencies
```bash
mvn clean install
```

### 2. Run tests
```bash
mvn test
```

---

## Test Coverage

This automation covers:

- User login flow
- Product selection
- Add to cart functionality
- Checkout process
- Product sorting validation
- End-to-end purchase journey

---

## Notes

- This project uses a demo application (MyDemoApp), so data is not persisted.
- Appium is used to simulate real mobile device interaction.
- Tests are designed for Android UI automation only.

---

## Prerequisites

Before running tests, make sure:

- Appium Server is running
- Android emulator or real device is connected
- Device capabilities are correctly set in DriverManager

---

## Author

Mira Reina Maharani