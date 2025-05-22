# E-Commerce

This is a Java-based web application of an e-commerce website; customers can browse items, manage carts and orders, and update delivery information; admin can manage products/orders.

## Technologies

**Front-end**: React.js, HTML, CSS

**Back-end**: Java, SpringBoot, JPA(Hibernate), MySQL

## Features

### Users
- Sign up for a new user account.
- Change user information (e.g., delivery address/email).
- Search items by name and category; browse items and their detail page.
- Add items to Cart; Submit Order by selecting items on Cart.
- Manage orders: keep track of orders' details, including delivery status, and take action on orders.

### Admin
- Register for a new user account.
- Manage goods, including creating a new item, revising an existing item, or deleting an item.
- Manage orders, including tracking order status and taking delivery actions.

## Team Members

| Role                   | Name        |
|------------------------|-------------|
| Product Owner/Developer | Amritanshu  |
| Scrum Master/Developer  | Achyuth     |
| Developer               | Santhoshram |
| Developer               | Kamal Yadav |


# Sprint Plan

## Sprint 1: Project Setup and Initial Development

- **Duration**: 1 week
- **Goals**:
  - Set up project repositories and environments.
  - Initialize frontend and backend frameworks.
  - Implement user registration and login functionality.
    
- **Key Tasks**:
  - Set up React and Spring Boot projects.
  - Configure database connections.
  - Develop user authentication module.
  - Create initial wireframes for user interface.

## Sprint 2: Product Management Module

- **Duration**: 1 week
- **Goals**:
  - Develop product management features.
  - Implement CRUD operations for products.
  - Create product listing and detail pages.
    
- **Key Tasks**:
  - Design product entity and database schema.
  - Develop product creation, update, and delete functionalities.
  - Implement product listing and detail views in frontend.
  - Validate and store product data in backend.

## Sprint 3: Shopping Cart and Order Management Modules

- **Duration**: 1 week
- **Goals**:
  - Implement shopping cart functionalities.
  - Develop order processing and tracking features.
  - Implement payment processing.
    
- **Key Tasks**:
  - Design cart item and order entities and database schema.
  - Develop add/remove item functionalities for the cart.
  - Create shopping cart page in frontend.
  - Develop order placement and tracking functionalities.
  - Integrate payment gateway.
  - Create order confirmation and tracking pages in frontend.

## Sprint 4: Admin Dashboard Module

- **Duration**: 1 week
- **Goals**:
  - Implement admin dashboard functionalities.
  - Allow admins to manage products, orders, and users.
    
- **Key Tasks**:
  - Design admin entity and database schema.
  - Develop admin management features.
  - Create admin dashboard interface.
  - Generate sales analytics and reports.

## Sprint 5: Testing, Deployment, and Final Review

- **Duration**: 1 week
- **Goals**:
  - Perform comprehensive testing.
  - Deploy the application locally.
  - Finalize the application and launch the platform.
    
- **Key Tasks**:
  - Conduct unit, integration, and end-to-end testing.
  - Fix bugs and optimize performance.
  - Deploy frontend and backend locally.
  - Prepare deployment documentation.
  - Review and finalize all features.
  - Conduct final testing.
  - Launch the application.
  - Monitor and gather user feedback.

## Entities

### Admin Entity
| Field       | Type    | Description                  |
|-------------|---------|------------------------------|
| AdminID     | string  | Unique admin identifier      |
| Name        | string  | Admin name                   |
| Role        | string  | Role (e.g., superadmin)      |
| Permissions | array   | List of allowed actions      |

### User Entity

| Field           | Type    | Description                     |
|-----------------|---------|---------------------------------|
| UserID          | string  | Unique user identifier          |
| Name            | string  | Full name                       |
| Email           | string  | Email address                   |
| Password        | string  | Hashed password                 |
| ShippingAddress | string  | Default shipping address        |
| PaymentDetails  | string  | Stored payment method info      |

### Product Entity

| Field       | Type    | Description              |
|-------------|---------|--------------------------|
| ProductID   | string  | Unique identifier        |
| Name        | string  | Product name             |
| Description | string  | Product description      |
| Price       | number  | Product price            |
| Category    | string  | Product category         |
| ImageURL    | string  | URL to product image     |

### Order Entity

| Field           | Type    | Description                        |
|-----------------|---------|------------------------------------|
| OrderID         | string  | Unique order identifier            |
| UserID          | string  | ID of the user placing the order   |
| TotalPrice      | number  | Total order price                  |
| ShippingAddress | string  | Delivery address                   |
| OrderStatus     | string  | Status: pending/shipped/delivered |
| PaymentStatus   | string  | Status: paid/unpaid/failed         |

### CartItem Entity

| Field       | Type    | Description              |
|-------------|---------|--------------------------|
| CartItemID  | string  | Unique identifier        |
| ProductID   | string  | Linked product ID        |
| Quantity    | number  | Quantity of the product  |
| TotalPrice  | number  | Total price for the item |

## API Endpoints

### Product
- **GET /products** – List all products
- **GET /products/{id}** – Get product by ID
- **POST /products** – Create a new product
- **PUT /products/{id}** – Update a product
- **DELETE /products/{id}** – Delete a product
- **GET /products/category/{category}** – Get products by category

### CartItem
- **GET /cart/{userId}** – Get cart items for a user
- **POST /cart/{userId}** – Add item to cart
- **PUT /cart/{userId}/{cartItemId}** – Update quantity
- **DELETE /cart/{userId}/{cartItemId}** – Remove item from cart
- **DELETE /cart/{userId}** – Clear cart

### Order
- **POST /orders** – Place a new order
- **GET /orders/{userId}** – Get all orders for a user
- **GET /orders/details/{orderId}** – Get order details
- **PUT /orders/status/{orderId}** – Update order status
- **PUT /orders/payment/{orderId}** – Update payment status

### User
- **POST /auth/register** – Register a new user
- **POST /auth/login** – Login
- **GET /users/{userId}** – Get user profile
- **PUT /users/{userId}** – Update user profile

### Admin
- **GET /admin/products** – View/manage all products
- **GET /admin/orders** – View all orders
- **GET /admin/users** – View all users
- **GET /admin/reports/sales** – Generate sales reports
- **GET /admin/reports/analytics** – View analytics


## Project Structure

## Backend
 
```
backend/                      # Spring Boot backend
├── src/
│   ├── main/
│   │   ├── java/com/ecommerce/
│   │   │   ├── EcommerceApplication.java
│   │   │   ├── config/         # App & security configs
│   │   │   ├── controller/     # API endpoints
│   │   │   ├── model/          # JPA entities
│   │   │   ├── repository/     # Data access
│   │   │   ├── service/        # Business logic
│   │   │   └── dto/            # Request/response objects
│   │   └── resources/
│   │       └── application.properties
├── test/                      # Unit tests
└── pom.xml
```
