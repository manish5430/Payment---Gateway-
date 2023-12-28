# Payment Service with Java and Spring Boot

Welcome to the Payment Service developed in Java using Spring Boot! This project provides a comprehensive payment system where you can manage clients, their payment details, addresses, and products with quantities in store. The application includes CRUD operations for clients and products, along with relationships between clients, addresses, payments, and products.

## Features
- Java and Spring Boot-based payment service.
- CRUD operations for clients and products.
- Relationship management between clients, addresses, payments, and products.
- Modern and scalable architecture.

## Requirements
- Java Development Kit (JDK) 11 or higher.
- Spring Boot.

## How to Run
1. Clone the repository to your local machine (or download the ZIP file).
2. Navigate to the project directory.
3. Build the project.
    ```bash
    ./mvnw clean install
    ```
4. Run the application.
    ```bash
    ./mvnw spring-boot:run
    ```
5. Access the application at [http://localhost:8080](http://localhost:8080).

## Endpoints
- **Clients:**
  - `GET /clients`: Retrieve all clients.
  - `GET /clients/{id}`: Retrieve a specific client.
  - `POST /clients`: Create a new client.
  - `PUT /clients/{id}`: Update an existing client.
  - `DELETE /clients/{id}`: Delete a client.

- **Products:**
  - `GET /products`: Retrieve all products.
  - `GET /products/{id}`: Retrieve a specific product.
  - `POST /products`: Create a new product.
  - `PUT /products/{id}`: Update an existing product.
  - `DELETE /products/{id}`: Delete a product.

## Entity Relationships
- **Client Entity:**
  - One-to-One relationship with Address.
  - One-to-Many relationship with Payment.

- **Payment Entity:**
  - Many-to-One relationship with Client.

- **Product Entity:**
  - Many-to-Many relationship with Client (representing products purchased by clients).

## Code Structure
- The code follows a modular structure, with packages for controllers, services, repositories, and entities.
- Entities include `Client`, `Address`, `Payment`, and `Product`.
- Repository interfaces manage data access for each entity.
- Services handle business logic.
- Controllers define REST endpoints.

## Contributing
If you would like to contribute to the project, please follow the standard GitHub workflow:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make changes and commit them with descriptive messages.
4. Push your branch to your fork.
5. Open a pull request with a detailed explanation of your changes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Feel free to explore the code, contribute improvements, or use it as a starting point for your own projects. Happy coding!
