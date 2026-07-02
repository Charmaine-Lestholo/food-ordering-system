package com.jumpstart.food_ordering_system.exception;


public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
