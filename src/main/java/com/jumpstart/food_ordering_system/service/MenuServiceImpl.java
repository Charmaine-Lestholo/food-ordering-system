package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.exception.MenuNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
import com.jumpstart.food_ordering_system.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Response<MenuDto> createMenu(MenuDto dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(
                        "Category not found with id: " + dto.getCategoryId()
                ));

        Menu menu = mapToEntity(dto, category);

        Menu saved = menuRepository.save(menu);

        return Response.created(
                "Menu created successfully",
                mapToDto(saved)
        );
    }

    @Override
    public Response<MenuDto> getMenuById(Long id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException(
                        "Menu not found with id: " + id
                ));

        return Response.success(
                "Menu retrieved successfully",
                mapToDto(menu)
        );
    }

    @Override
    public Response<MenuDto> updateMenu(Long id, MenuDto dto) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException(
                        "Menu not found with id: " + id
                ));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(
                        "Category not found with id: " + dto.getCategoryId()
                ));

        menu.setName(dto.getName());
        menu.setDescription(dto.getDescription());
        menu.setPrice(dto.getPrice());
        menu.setImageUrl(dto.getImageUrl());
        menu.setCategory(category);

        Menu updated = menuRepository.save(menu);

        return Response.success(
                "Menu updated successfully",
                mapToDto(updated)
        );
    }

    @Override
    public Response<Void> deleteMenu(Long id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException(
                        "Menu not found with id: " + id
                ));

        menuRepository.delete(menu);

        return Response.success("Menu deleted successfully", null);
    }

    @Override
    public Response<List<MenuDto>> getAllMenus(
            Long categoryId,
            String search,
            Pageable pageable
    ) {

        Page<Menu> page;

        boolean hasCategory = categoryId != null;
        boolean hasSearch = search != null && !search.isBlank();

        if (hasCategory && hasSearch) {
            page = menuRepository.findByCategoryIdAndNameContainingIgnoreCase(
                    categoryId, search, pageable
            );
        } else if (hasCategory) {
            page = menuRepository.findByCategoryId(categoryId, pageable);
        } else if (hasSearch) {
            page = menuRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            page = menuRepository.findAll(pageable);
        }

        List<MenuDto> content = page.getContent()
                .stream()
                .map(this::mapToDto)
                .toList();

        Response<List<MenuDto>> response = Response.success(
                "Menus retrieved successfully",
                content
        );

        // attach pagination metadata
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setNumber(page.getNumber());
        response.setSize(page.getSize());
        response.setFirst(page.isFirst());
        response.setLast(page.isLast());

        return response;
    }

    // ---------------- MAPPING ----------------

    private MenuDto mapToDto(Menu menu) {

        MenuDto dto = new MenuDto();

        dto.setId(menu.getId());
        dto.setName(menu.getName());
        dto.setDescription(menu.getDescription());
        dto.setPrice(menu.getPrice());
        dto.setImageUrl(menu.getImageUrl());

        dto.setCategoryId(menu.getCategory().getId());
        dto.setCategoryName(menu.getCategory().getName());

        return dto;
    }

    private Menu mapToEntity(MenuDto dto, Category category) {

        return Menu.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .category(category)
                .build();
    }
}
