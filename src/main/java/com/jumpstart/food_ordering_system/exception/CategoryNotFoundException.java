package com.jumpstart.food_ordering_system.exception;

/**
 * Custom exception used when
 * a category cannot be found.
 */
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
