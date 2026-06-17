package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryDto(
                        category.getId(),
                        category.getName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException(
                                "Category not found with id: " + id
                        ));

        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }

    @Override
    public CategoryDto addCategory(CategoryDto dto) {

        Category category = new Category();
        category.setName(dto.getName());

        Category savedCategory = categoryRepository.save(category);

        return new CategoryDto(
                savedCategory.getId(),
                savedCategory.getName()
        );
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException(
                                "Category not found with id: " + id
                        ));

        category.setName(dto.getName());

        Category updatedCategory = categoryRepository.save(category);

        return new CategoryDto(
                updatedCategory.getId(),
                updatedCategory.getName()
        );
    }

    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException(
                                "Category not found with id: " + id
                        ));

        categoryRepository.delete(category);
    }
}
