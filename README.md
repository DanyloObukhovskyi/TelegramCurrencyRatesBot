# Telegram Currency Application

This is a simple Spring Boot application for fetching currency exchange rates. The application includes a sample service (`NpbService`) that sends request at 8:00 AM everyday to get exchange rates from National Polish Bank and stores it in MySql database. Than you could setup your own Telegram bot to get currency rates by command "/getTodayRates".

## Features

- Fetch exchange rate for predefined currencies.

### Prerequisites

- Java 11 or higher
- Maven
- MySql 8.0
- Docker

### Running the Application

1. Clone the repository.
2. Navigate to the project root directory.
3. Than you need utilize docker-compose.yml file to create working environment

### Configuration

The application can be configured via the application.properties file.
However all of this configurations would be setted up by docker-compose.yml (except telegram token).

- telegram.token=token which was generated utilizing telegram documentation

Documentation reference: https://core.telegram.org/bots

If you do not have any data in database you should setup sample mocks for test purposes. Database schema would be included in repository.

## Project Structure

src/main/java: Main application and service code.

## License
This project is licensed under the MIT License.
