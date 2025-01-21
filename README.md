# PetCare - Gestão de Marcações de Passeios e Educação Animal

## Course: Programming II


#### Developed by:
- Pedro Poças, Student Number: 28976

## Project Overview
"PetCare" is a software application developed to manage scheduling for pet walking and training services. This application serves various user roles such as pet owners, service providers, employees, and system administrators, facilitating the registration and management of services and user interactions within the system.

## Features
- **User Registration**: Separate registration paths for pet owners and clients.
- **Service Management**:
  - Owners can register their service providing company and manage employees.
  - Clients can book services for registered pets, specifying the service provider and desired time.
- **Administrative Functions**:
  - System administrators can manage user roles, including adding new admins and overseeing service provider activities.
- **Data Management**:
  - Utilizes repositories to manage and persist data within the system.
  - Capabilities to read and write data to text files, handling service requests and user information.

## Implementation
- **Class Model**: The application's architecture is designed with a superclass `User` divided into four subclasses: `Admin`, `Cliente`, `Dono`, and `Funcionario`, facilitating diverse functionalities tailored to each user type.
- **Use Case Model**: Demonstrates interactions across various user roles with detailed use case scenarios.
- **Graphical User Interface (GUI)**:
  - Developed using Java Swing.
  - Features include registration, login, and service booking among others.

## Challenges and Learning Outcomes
- The project provided extensive practice with Java inheritance, collections (Lists, Maps), file management, and GUI development.
- Focused on optimizing code for better performance and memory efficiency.

## Conclusions
This project enhanced understanding of object-oriented programming and GUI implementation, highlighting practical application of programming concepts taught in the course. The challenge of implementing a user-friendly interface was particularly valuable in understanding the intricacies of software development.

