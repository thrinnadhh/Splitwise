📊 Splitwise Clone – Expense Sharing App
A backend application that mimics the functionality of Splitwise, designed using Spring Boot (MVC architecture) and PostgreSQL. It supports group-based expense management, calculating optimized settlement between users using various strategies.

🏗️ Project Architecture
MVC (Model-View-Controller):

Models: Represent domain entities like User, Group, Expense, and Transaction.

Controllers: Handle incoming requests (e.g., SettleUpController) and route responses.

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

Testing: JUnit (add test coverage as needed)

📂 Directory Structure (Core Modules)
css
Copy
Edit
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
Clone the Repository

bash
Copy
Edit
git clone https://github.com/thrinnadhh/Splitwise.git
cd Splitwise
Configure PostgreSQL DB

Create a DB (e.g., splitwise_db)

Update credentials in application.properties:

ini
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/splitwise_db
spring.datasource.username=your_username
spring.datasource.password=your_password
Build & Run

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
Interact with the System

Use command-line inputs or integrate REST endpoints (extendable).

Example usage handled by CommandExecutor and SettleUpGroupCommand.

📊 Sample Output
On successful settlement, the CLI prints:

sql
Copy
Edit
Group transactions are settled successfully
The transactions are:
Alice paid Bob ₹500.00
Charlie paid Alice ₹300.00
🔍 Future Enhancements
REST API integration using Spring Web

Frontend using React or Angular

OAuth2/JWT authentication

Dockerization

Expense categories, due dates, and recurring payments

Email/SMS notifications
