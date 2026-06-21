# Bibit Web Automation Testing

An automation testing project for the Bibit website using Selenium WebDriver, Cucumber, Java, and the Page Object Model (POM) design pattern.

This project simulates a complete user journey starting from login, searching for the EMAS investment product, and ending with logout.

---

## Tech Stack

- Java 17
- Selenium WebDriver 4.15.0
- Cucumber 7.18.1
- JUnit 4.13.2
- Maven
- WebDriverManager 5.9.2

---

## Project Structure

```text
src
└── test
    ├── java
    │   ├── hooks
    │   │   └── Hooks.java
    │   ├── pages
    │   │   ├── LoginPage.java
    │   │   ├── ExplorePage.java
    │   │   └── LogoutPage.java
    │   ├── runners
    │   │   └── TestRunner.java
    │   ├── stepdefinitions
    │   │   └── BibitSteps.java
    │   └── utils
    │       ├── DriverManager.java
    │       └── SessionState.java
    └── resources
        └── features
            └── bibit.feature
```text

---

## Test Scenario

### Login - Search EMAS Product Investasi - Logout

Automation flow:

1. Open Bibit login page
2. Enter registered phone number
3. Click Login button
4. Complete OTP verification manually
5. Complete PIN verification manually
6. Navigate to Explore page
7. Search investment product "EMAS"
8. Open EMAS product detail page
9. Verify Buy product detail "EMAS" is displayed
10. Navigate back to Home page
11. Open Profile page
12. Scroll to Logout section
13. Click Logout button
14. Verify user is redirected to landing page

---

## Authentication Flow

Bibit uses OTP-based authentication.

### Automated Steps:
- Open login page
- Input phone number
- Click login button

### Manual Steps:
- Input OTP code manually
- Input PIN manually

After authentication success, automation continues automatically.

---

## How to Run Project

### Install dependencies
```bash
mvn clean install
```

### Run test
```bash
mvn test
```

---

## Expected Result

If test runs successfully:

BUILD SUCCESS
Tests run: 1
Failures: 0
Errors: 0
Skipped: 0

---

## Notes 

- OTP and PIN cannot be automated due to security system of Bibit.
- Manual input is required during login process.
- Browser will be automatically closed after test execution.
- WebDriverManager is used to manage ChromeDriver automatically.

---

## Framework Design

### Page Object Model (POM)

Separation of concerns:
- Page classes handle locators & UI actions
- Step Definitions handle business logic flow
- Hooks manage setup and teardown

### Cucumber BDD

Test scenarios are written in Gherkin format for readability.

---

## Author

Mira Reina Maharani