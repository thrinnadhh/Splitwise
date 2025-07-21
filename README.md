💸 Splitwise Clone – Expense Sharing App (Backend)
🚀 Project Overview
This project is a robust backend application designed to mimic the core functionalities of Splitwise, a popular expense-sharing platform. Built with Spring Boot following an MVC architecture and backed by a PostgreSQL database, it enables users to manage group-based expenses and efficiently calculate optimized settlements. The application incorporates various design patterns and algorithms to ensure modularity, scalability, and effective debt resolution.

✨ Features
✅ User & Group Management: Create and manage users and expense groups.

✅ Expense Tracking: Add detailed expenses, assigning payees and specifying payers.

✅ Automatic Splitting: Automatically split expenses among group members.

✅ Optimized Settlements: Settle up group balances using efficient algorithms to minimize the number of transactions required.

✅ Custom Strategies: Support for different expense optimization strategies (e.g., Heap-based, General).

✅ Clear Transaction Output: Provides a clear, detailed output of calculated settlement transactions.

✅ Modular Design: Implemented with a modular, testable command pattern for flexible interaction.

🏗️ Project Architecture
The application follows a clean MVC (Model-View-Controller) architecture, enhanced with specific design patterns for clarity and separation of concerns:

Models (com.projects.splitwise.models):

Represent the core domain entities such as User, Group, Expense, and Transaction.

Includes ExpenseType and UserExpenseType for detailed expense categorization.

UserExpense manages individual user contributions and shares within an expense.

Controllers (com.projects.splitwise.controllers):

Handle incoming requests and orchestrate the flow of data.

SettleUpController: Manages requests related to expense settlement.

Services (com.projects.splitwise.services):

Contain the primary business logic.

SettleUpGroupService: Implements the complex logic for calculating and optimizing group settlements.

Repositories (com.projects.splitwise.repositories):

The Data Access Object (DAO) layer responsible for interacting with the PostgreSQL database.

Utilizes Spring Data JPA for seamless database operations.

Commands (com.projects.splitwise.commands):

Implements the Command design pattern for handling CLI (Command Line Interface) inputs or programmatic command parsing.

Command: Interface for all commands.

CommandExecutor: Executes registered commands.

SettleUpGroupCommand: Specific command to trigger group settlement.

Strategies (com.projects.splitwise.strategies):

Encapsulate different algorithms for expense optimization.

HeapSettleUpStrategy: Likely uses a min-heap/max-heap approach for efficient transaction reduction.

GeneralSettleUpStrategy: A more general or alternative settlement algorithm.

DTOs (com.projects.splitwise.dtos):

Data Transfer Objects for request and response payloads.

SettleUpGroupRequestDto, SettleUpGroupResponseDto, Transaction.

🗃️ Tech Stack
Backend: Java 17+

Framework: Spring Boot

Architecture Patterns: MVC, Command Pattern, Strategy Pattern

Database: PostgreSQL

Build Tool: Maven

Testing: JUnit (with potential for more comprehensive test coverage)

🛠️ Setup Instructions
Follow these steps to get the Splitwise Clone backend up and running on your local machine.

1. Clone the Repository
git clone https://github.com/thrinnadhh/Splitwise.git
cd Splitwise

2. Configure PostgreSQL Database
First, ensure you have PostgreSQL installed and running.

Create a new PostgreSQL database (e.g., splitwise_db).

Update the database connection properties in src/main/resources/application.properties:

# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/splitwise_db
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here
spring.jpa.hibernate.ddl-auto=update # Or 'create' for first time setup to auto-create tables
spring.jpa.show-sql=true

Remember to replace your_username_here and your_password_here with your actual PostgreSQL credentials.

3. Build & Run the Application
Navigate to the Splitwise project root directory in your terminal and execute the following Maven commands:

mvn clean install
mvn spring-boot:run

This will build the project, download dependencies, and start the Spring Boot application.

4. Interact with the System
Currently, interaction is primarily via command-line inputs handled by the CommandExecutor and SettleUpGroupCommand. You can extend this by integrating REST APIs (see Future Enhancements).

📊 Sample Output
When a group's transactions are settled using the SettleUpGroupCommand, you can expect an output similar to this:

Group transactions are settled successfully
The transactions are:
Alice paid Bob ₹500.00
Charlie paid Alice ₹300.00

🔍 Future Enhancements
The following features are planned or can be added to further enhance the application:

REST API Integration: Implement comprehensive RESTful endpoints using Spring Web for broader client accessibility.

Frontend UI: Develop a user-friendly web interface using frameworks like React or Angular.

Authentication: Integrate OAuth2/JWT for secure user authentication and authorization.

Docker Support: Provide Dockerfiles and compose configurations for containerized deployment.

Expense Details: Add features for expense categories, due dates, and recurring payments.

Notifications: Implement Email/SMS notification services for transaction updates and reminders.

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

🧑‍💻 Author
[Your Name/Thrinnadhh]

[Optional: Link to your LinkedIn profile]

[Optional: Link to your personal website/portfolio]

[Optional: Your Email Address]
