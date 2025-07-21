📊 Splitwise Clone – Expense Sharing App
A backend application that mimics the functionality of Splitwise, designed using Spring Boot (MVC architecture) and PostgreSQL. It supports group-based expense management and calculates optimized settlements between users using various strategies.

🏗️ Project Architecture
MVC (Model-View-Controller):

Models: Represent domain entities like User, Group, Expense, and Transaction.

Controllers: Handle incoming requests (e.g., SettleUpController) and return responses.

Services: Business logic layer (e.g., SettleUpGroupService).

Repositories: DAO layer to interact with PostgreSQL DB.

Commands: Handles CLI input or programmatic command parsing (e.g., SettleUpGroupCommand).

Strategies: Contains expense settlement algorithms (e.g., HeapSettleUpStrategy, GeneralSettleUpStrategy).

🧠 Features

✅ Create users and groups

✅ Add expenses and assign payees/payers

✅ Automatically split expenses

✅ Settle up group balances using efficient algorithms

✅ Custom strategies for expense optimization

✅ Clear output of transaction details

✅ Modular, testable command pattern


🗃️ Tech Stack
Backend: Java 17+, Spring Boot

Architecture: MVC with Command design pattern

Database: PostgreSQL

Build Tool: Maven

Testing: JUnit (test coverage can be added)

📂 Directory Structure (Core Modules)
src/main/java/com/projects/splitwise/
├── commands/
│   ├── Command.java
│   ├── CommandExecutor.java
│   └── SettleUpGroupCommand.java
├── controllers/
│   └── SettleUpController.java
├── dtos/
│   ├── SettleUpGroupRequestDto.java
│   ├── SettleUpGroupResponseDto.java
│   └── Transaction.java
├── models/
│   ├── User.java, Group.java, Expense.java, etc.
├── repositories/
│   └── [PostgreSQL JPA repositories]
├── services/
│   └── SettleUpGroupService.java
├── strategies/
│   ├── HeapSettleUpStrategy.java
│   └── GeneralSettleUpStrategy.java

🛠️ Setup Instructions
1. Clone the Repository
bash
git clone https://github.com/thrinnadhh/Splitwise.git
cd Splitwise
2. Configure PostgreSQL DB
Create a PostgreSQL database (e.g., splitwise_db)

Update the following in src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/splitwise_db
spring.datasource.username=your_username
spring.datasource.password=your_password
3. Build & Run
bash
mvn clean install
mvn spring-boot:run
4. Interact with the System
Use command-line inputs or extend with REST APIs.
Example usage is handled via CommandExecutor and SettleUpGroupCommand.

📊 Sample Output
Group transactions are settled successfully
The transactions are:
Alice paid Bob ₹500.00
Charlie paid Alice ₹300.00
🔍 Future Enhancements
REST API integration using Spring Web

Frontend UI using React or Angular

OAuth2/JWT authentication

Docker support for containerized deployment

Expense categories, due dates, and recurring payments

Email/SMS notifications
