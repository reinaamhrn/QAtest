# API Automation Testing

This project is an API automation framework built using Rest Assured, Cucumber, and JUnit.

The goal of this project is to validate basic CRUD operations on JSONPlaceholder API while also ensuring response structure consistency using JSON schema validation.

Test scenarios are written in Gherkin format for readability.

---

## Tech Stack

- Java 17
- Rest Assured 5.5.0
- Cucumber 7.20.1
- JUnit 4.13.2
- Maven
- JSON Schema Validator
- Masterthought Cucumber Reporting

---

## Project Structure

```text
src/test
├── java
│   ├── apis
│   │   └── PostAPI.java
│   ├── hooks
│   │   └── Hooks.java
│   ├── runners
│   │   └── TestRunner.java
│   ├── stepdefinitions
│   │   └── APISteps.java
│   └── utils
│       └── BaseAPI.java
└── resources
    ├── features
    │   └── api.feature
    └── schemas
        ├── delete-schema.json
        ├── get-schema.json
        ├── post-schema.json
        └── posts-schema.json
```

---

## What This Project Covers

This automation focuses on testing the core API operations:

- Create a new post (POST)
- Retrieve all posts (GET)
- Update existing post (PUT)
- Delete a post (DELETE)

Each request is validated not only by status code, but also by response body and JSON schema.

---

## Test Scenarios

### Create Post
- Send POST request to create a new post
- Validate status code 201
- Verify title, body, and userId in response
- Response matches JSON schema

### Get Posts
- Send GET request to retrieve posts
- Validate status code 200
- Ensure each post contains valid id
- Response matches JSON schema

### Update Post
- Update post with id 1 using PUT request
- Validate updated fields in response
- Check status code 200
- Response matches JSON schema

### Delete Post
- Delete post with id 1
- Validate status code 200
- Ensure response confirms deletion
- Response matches JSON schema

---

## Framework Approach

The framework is separated into multiple layers to keep things clean and reusable:

- Step Definitions handle Cucumber step logic
- API classes manage request logic for each endpoint
- Base class handles shared configuration like base URL and request setup
- JSON schemas are used to validate response structure

---

## How to Run

Run all tests:
```bash
mvn clean verify
```

Generate report:
```bash
open target/cucumber-reports/cucumber-html-reports/overview-features.html
```

---

## Reports

After execution, Cucumber HTML report will be generated at:

```
target/cucumber-reports/
```

Open `overview-features.html` to view detailed test execution results.

---

## API Used

This project uses JSONPlaceholder :

https://jsonplaceholder.typicode.com

---

## Notes

- JSONPlaceholder is a fake API, so data is not actually persisted.
- DELETE and PUT responses are simulated.
- Schema validation ensures response structure consistency.

---

## Author

Mira Reina Maharani