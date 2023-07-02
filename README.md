# Buggy Cars Rating API Test

I have automated the API test using Postman and I'm sharing the Postman collection. 

To execute the Postman collection using Newman, kindly follow the instructions below:

	Ensure you have Node.js and NPM (Node Package Manager) installed on your machine.

	Open your command-line interface (e.g., Terminal, Command Prompt).

	Install Newman globally by running the following command:

		npm install -g newman
	Download the Postman collection file (BuggyCars.json) to your local machine.

	Open your command-line interface and navigate to the directory where the Postman collection file is located.

	Run the following command to execute the collection using Newman:

		newman run BuggyCars.json

	Newman will start running the collection, and you will see the test results displayed in the command-line interface.

 # Buggy Cars Rating UI Test
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
