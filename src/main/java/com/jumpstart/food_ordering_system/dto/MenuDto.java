package com.jumpstart.food_ordering_system.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MenuDto {

    private Long id;

    @NotBlank(message = "Menu name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = true,
            message = "Price cannot be negative")
    private BigDecimal price;

    private String imageUrl;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    private String categoryName;

    public MenuDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Menu name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Menu name is required") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotNull(message = "Price is required") @DecimalMin(value = "0.0", inclusive = true, message = "Price cannot be negative") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price is required") @DecimalMin(value = "0.0", inclusive = true, message = "Price cannot be negative") BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @NotNull(message = "Category ID is required") Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "Category ID is required") Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}