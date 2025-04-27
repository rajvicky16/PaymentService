# Payment Service

This is a Spring Boot-based microservice for handling payment link generation using multiple payment providers like Razorpay and Stripe.

## Features

- Generate payment links using Razorpay and Stripe.
- Easily switch between payment providers using Spring's `@Qualifier`.
- Modular and extensible design for adding new payment providers.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Maven**: Dependency management and build tool.
- **Stripe API**: For payment link generation with Stripe.
- **Razorpay API**: For payment link generation with Razorpay.

## Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
- Stripe and Razorpay API keys

## Configuration

Add the following properties to your `application.properties` file:
```properties
stripe.api.key=your_stripe_api_key
razorpay.api.key=your_razorpay_api_key
razorpay.api.secret=your_razorpay_api_secret
```

### Usage
The PaymentServiceImpl class uses the @Qualifier annotation to select the payment provider. By default, it is configured to use Razorpay. To switch to Stripe, update the @Qualifier value in the constructor of PaymentServiceImpl.


 ## How to Run
 
 ### Clone the Repository
 ```bash
 git clone https://github.com/rajvicky16/paymentservice.git
 cd paymentservice
 ```
 
 ### Build the Project
 Run the following command to build the project:
 ```bash
 mvn clean install
 ```


 ### Run the Application
 You can run the PaymentServiceApplication class directly from your IDE.
