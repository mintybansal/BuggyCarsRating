# BuggyCarsRating
**Prerequisites**

Programming Language: Java 1.8 or above

Build Management: Maven 

IDE -IntelliJ IDEA (Community) 

**Frameworks:**

Cucumber (BDD)

Selenium WebDriver 

TestNG (Unit Testing)

**Design:**

BDD - Scenarios, Data Tables, Scenario Outline, Examples

Pages - Page Factory Pattern, Page Objects

Parallel Execution - maven-surefire-plugin and TestNG (3 threads)

Utilities - Lombok and log4j for logger management

**Reports:**

Default - target/surefire-reports/emailable-report.html (emailable-report)

JSON - target/cucumber-reports/CucumberTestReport.json 

Logs - target/logs/main.log and scenario based logs (analyse runtime failures and progress)

**Test Execution:**

In a terminal navigate to project root directory and run mvn clean test
