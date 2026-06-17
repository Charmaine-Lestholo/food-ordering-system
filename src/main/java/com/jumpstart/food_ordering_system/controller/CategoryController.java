package com.jumpstart.food_ordering_system.controller;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(
            CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>>
    getAllCategories() {

        return ResponseEntity.ok(
                categoryService.getAllCategories()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto>
    getCategoryById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                categoryService.getCategoryById(id)
        );
    }

    @PostMapping
    public ResponseEntity<CategoryDto>
    createCategory(
            @RequestBody @Valid CategoryDto dto
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        categoryService.addCategory(dto)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto>
    updateCategory(
            @PathVariable Long id,
            @RequestBody @Valid CategoryDto dto
    ) {

        return ResponseEntity.ok(
                categoryService.updateCategory(
                        id,
                        dto
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    deleteCategory(
            @PathVariable Long id
    ) {

        categoryService.deleteCategory(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}