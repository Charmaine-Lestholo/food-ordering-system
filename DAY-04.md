# Food Ordering System REST API

## Overview

The Food Ordering System is a Spring Boot REST API designed to manage food categories and menu items for a restaurant or food ordering platform. The application provides a structured backend that allows users to create, retrieve, update, and delete categories and menu items while maintaining data integrity and consistent API responses.

The project follows RESTful design principles and uses a layered architecture consisting of controllers, services, repositories, and entities. All endpoints return a standardized response format to provide consistent status information and payloads.



## How It Works

The API allows administrators to manage food categories and menu items. Each menu item belongs to a valid category, ensuring referential integrity. Clients can retrieve menu items using optional search, category filtering, pagination, and sorting query parameters, making it efficient to browse large collections of data.

The application validates incoming requests, handles exceptions gracefully, and returns meaningful HTTP status codes and messages for both successful and unsuccessful operations.

## Project Status

This project currently includes the complete implementation of the Week 2 Menu Module, including CRUD operations, filtering, searching, pagination, sorting, validation, and global exception handling as specified in the project requirements.

## API Endpoints

### Category Endpoints

| Method | Endpoint               | Description                                                                      |
| ------ | ---------------------- | -------------------------------------------------------------------------------- |
| GET    | `/api/categories`      | Retrieve all categories                                                          |
| GET    | `/api/categories/{id}` | Retrieve a category by its ID                                                    |
| POST   | `/api/categories`      | Create a new category                                                            |
| PUT    | `/api/categories/{id}` | Update an existing category                                                      |
| DELETE | `/api/categories/{id}` | Delete a category (returns **409 Conflict** if the category contains menu items) |

### Menu Endpoints

| Method | Endpoint         | Description                  | Query Parameters                               |
| ------ | ---------------- | ---------------------------- | ---------------------------------------------- |
| POST   | `/api/menu`      | Create a new menu item       | None                                           |
| GET    | `/api/menu`      | Retrieve menu items          | `categoryId`, `search`, `page`, `size`, `sort` |
| GET    | `/api/menu/{id}` | Retrieve a menu item by ID   | None                                           |
| PUT    | `/api/menu/{id}` | Update an existing menu item | None                                           |
| DELETE | `/api/menu/{id}` | Delete a menu item           | None                                           |


```



