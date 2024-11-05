# Telegram Currency Application

This is a simple Spring Boot application for fetching currency exchange rates. The application includes a sample service (`NpbService`) that sends request at 8:00 AM everyday to get exchange rates from Main Polish Bank and stores it in MySql database. Than if you could setup your own Telegram bot to get currency rates by command "/getTodayRates".

## Features

- Fetch exchange rate for predefined currencies (USD, EUR, JPY).
- Easily extendable for additional currencies and functionality.

## Setup

### Prerequisites

- Java 11 or higher
- Maven
- MySql 8.0

### Running the Application

1. Clone the repository.
2. Navigate to the project root directory.
3. Run the following command to start the application:

   ```bash
   ./mvnw spring-boot:run

- The application will start on http://localhost:8080.

### Configuration

The application can be configured via the application.properties file.

- spring.application.name=telegram
- spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
- spring.datasource.username=yourusername
- spring.datasource.password=yourpassword
- spring.jpa.generate-ddl=true
- spring.jpa.hibernate.ddl-auto=update
- telegram.token=token which was generated utilizing telegram documentation

Documentation reference: https://core.telegram.org/bots

If you do not have any data in database you should setup sample mocks for test purposes. Database schema would be included in repository.

Running Tests
To run the tests, use the following command:

    ./mvnw test

## Project Structure

src/main/java: Main application and service code.
src/test/java: Unit tests.

## License
This project is licensed under the MIT License.
