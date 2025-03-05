# Fetch Assessment - Test Automation Framework

This is a **BDD (Behavior-Driven Development) Test Automation Framework** using:
- **Cucumber** for BDD
- **JUnit** for test execution
- **RestAssured** for API testing
- **Selenium WebDriver** for UI testing
- **Maven** for dependency management

---

## Project Structure
```
Fetch_Assesment/
│── src
│   ├── test
│   │   ├── java
│   │   │   ├── org.fetch
│   │   │   │   ├── pages               # Page Object Models (UI testing)
│   │   │   │   │   
│   │   │   │   │   
│   │   │   │   ├── runners             # Test runners
│   │   │   │   │   ├── TestRunner.java
│   │   │   │   │   ├── FailedTestRunner.java
│   │   │   │   ├── step_definitions    # Step definitions for BDD scenarios
│   │   │   │   │   ├── ApiTestsSteps.java
│   │   │   │   │   ├── Hooks.java
│   │   │   │   ├── utilities           # Utility classes
│   │   │   │   │   ├── APIClient.java
│   │   │   │   │   ├── ConfigurationReader.java
│   │   │   │   │   ├── Driver.java
│   │   │   │   │   ├── Geolocator.java

│   ├── resources
│   │   ├── features                   # Feature files for Cucumber
│   │   │   ├── apiTests.feature
│── .gitignore                          # Ignore files like `target/`, `.idea/`, etc.
|── configuration.properties             # Config file for base URL, API key, browser type, etc.
│── pom.xml                             # Maven dependencies and plugins
│── README.md                           # Project documentation

```
---

## Setup Instructions
### 1️⃣ Prerequisites
- **Java 17** (Ensure it’s installed: `java -version`)
- **Maven** (Check with: `mvn -version`)
- **IDE** (IntelliJ or VS Code with Cucumber and Java plugins)
- **Google Chrome** (For Selenium execution, if needed)

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/your-repo/Fetch_Assesment.git
cd Fetch_Assesment
```

### 3️⃣ Configure Properties
Update the `configuration.properties` file:
```properties
fetch.baseURI=https://api.openweathermap.org
apiKey=your_api_key_here
browser=chrome
```
---
## Command Line Utility
To fetch geolocation data using the CLI tool:

1. **Compile the Project**
   ```sh
   mvn clean compile


## Running Tests
### 1️⃣ Run All Tests
```sh
mvn clean test
```

### 2️⃣ Run Specific Tests
#### Using Cucumber Tags
```sh
mvn test -Dcucumber.filter.tags="@geolocation"
```

### 3️⃣ Generate Cucumber Report
After execution, **open the generated report**:
```sh
open target/cucumber-reports/cucumber-html-reports/overview-features.html
```
---

## Key Features
### - API Testing
- Uses **RestAssured** to validate API responses.
- Fetches geolocation data from OpenWeather API.
- `APIClient.java` handles API requests.

### - BDD with Cucumber
- Feature files located in `src/test/resources/features/`
- Step definitions in `step_definitions/`

### - Parallel Execution
- Enabled using `maven-surefire-plugin`
- Runs tests in multiple browser instances (if applicable)

---

## - Sample Feature File
```gherkin
Feature: Fetch Geolocation Data

  @geolocation
  Scenario Outline: Get coordinates for different cities
    Given I have a city "<city>"
    When I request the geolocation API
    Then the response should return status code 200
    And the response should contain valid latitude and longitude

  Examples:
    | city          |
    | Los Angeles  |
    | New York     |
    | Chicago      |
    | San Francisco |
```
---

##  Dependencies (pom.xml)
Your project uses the following dependencies:
```xml
<dependencies>
    <!-- JUnit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.24.0</version>
    </dependency>

    <!-- Cucumber -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.10.1</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.10.1</version>
    </dependency>

    <!-- RestAssured -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.1</version>
    </dependency>
</dependencies>
```
---
---

## 📧 Contact
👩‍💻 **Roy Mishra**  
📧 **roymishra1229@gmail.com**  
🔗 **https://www.linkedin.com/in/roy-m-testninja/**

