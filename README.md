# Payment Service with Java and Spring Boot

This project is a fully functional payment service developed using Java and Spring Boot. It allows for efficient management of clients, payments, addresses, and products. The application provides the ability to perform CRUD operations on clients and products while maintaining relationships between different entities like clients, addresses, payments, and products. The system follows modern and scalable architecture to ensure extensibility and maintainability.

# Features
- Java & Spring Boot-Based Payment Service: Built using Spring Boot, allowing seamless backend functionality.
- CRUD Operations: Fully functional create, read, update, and delete operations for clients, products, and addresses.
- Relationship Management: Manages the relationship between clients, their addresses, payments, and the products they purchase.
- Payment Integration: Integrated with PayPal API for payment processing.
- Database Integration: JPA and Hibernate used for database operations, managing clients and product data effectively.
- Security: JWT-based authentication for secure endpoints and operations.

# What We Did
1. **Developed the Payment Gateway Integration:** Integrated PayPal API for processing payments. Implemented payment creation, success handling, and cancellation mechanisms.
2. **Designed CRUD Operations:** Developed backend services to manage clients, products, and addresses using Spring Data JPA.
3. **Managed Relationships:** Established relationships between different entities like clients, payments, products, and addresses for easy data management.
4. **Local Hosting:** Initially developed and tested the project locally using Spring Boot and Maven. The application was hosted locally on http://localhost:8090/ for testing purposes.
5. **Cloud Deployment on Render:** After successful local testing, deployed the application on Render, a cloud platform, ensuring that the project is accessible online at
   https://my-app-hckg.onrender.com/payments/create?total=10
7. **Dockerization:** The project was dockerized to ensure easy and consistent deployment across environments. Dockerfile and commands (docker build, docker push) were used to build and push the Docker image to the 
   container registry, ensuring seamless deployment.
8. **Integration with Render:** The project was linked to Render using the container registry. Commands like docker run and docker-compose were used to spin up containers, ensuring the app could scale and run without 
   issues in the cloud environment.
9. **Customized URLs:** Configured the redirect URLs for payment success and cancellation using Render’s hosted URLs, providing seamless interaction for end-users across the platform.

# Technologies Used:
- **Spring Boot** for backend development and creating REST APIs.
- **Maven** for dependency management and building the project.
- **Docker** for containerizing the application and deployment.
- **Render** for cloud deployment, ensuring high availability and scalability.
- **PayPal API** for payment gateway integration.
- **JPA/Hibernate** for database management.
- **JWT** for authentication and security.

![Log in to your PayPal account - Google Chrome 3_15_2025 9_58_17 AM](https://github.com/user-attachments/assets/cfb22b9a-7951-4b7f-a8e9-d60191c9aee9)
