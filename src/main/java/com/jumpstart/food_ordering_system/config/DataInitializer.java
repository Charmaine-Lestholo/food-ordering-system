package com.jumpstart.food_ordering_system.config;

import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MenuRepository menuRepository;

    @Override
    public void run(String... args) {

        if (categoryRepository.count() > 0 || menuRepository.count() > 0) {
            return;
        }

        // =========================
        // Categories
        // =========================

        Category pizza = new Category();
        pizza.setName("Pizza");

        Category burgers = new Category();
        burgers.setName("Burgers");

        Category drinks = new Category();
        drinks.setName("Drinks");

        categoryRepository.save(pizza);
        categoryRepository.save(burgers);
        categoryRepository.save(drinks);

        // =========================
        // Pizza
        // =========================

        menuRepository.save(createMenu(
                "Margherita Pizza",
                "Classic cheese pizza",
                new BigDecimal("89.99"),
                "margherita.jpg",
                pizza));

        menuRepository.save(createMenu(
                "Pepperoni Pizza",
                "Pepperoni and mozzarella",
                new BigDecimal("109.99"),
                "pepperoni.jpg",
                pizza));

        menuRepository.save(createMenu(
                "BBQ Chicken Pizza",
                "Chicken and BBQ sauce",
                new BigDecimal("129.99"),
                "bbq.jpg",
                pizza));

        menuRepository.save(createMenu(
                "Hawaiian Pizza",
                "Ham and pineapple",
                new BigDecimal("119.99"),
                "hawaiian.jpg",
                pizza));

        // =========================
        // Burgers
        // =========================

        menuRepository.save(createMenu(
                "Classic Burger",
                "Beef burger",
                new BigDecimal("69.99"),
                "burger1.jpg",
                burgers));

        menuRepository.save(createMenu(
                "Cheese Burger",
                "Beef with cheese",
                new BigDecimal("79.99"),
                "burger2.jpg",
                burgers));

        menuRepository.save(createMenu(
                "Chicken Burger",
                "Grilled chicken burger",
                new BigDecimal("74.99"),
                "burger3.jpg",
                burgers));

        menuRepository.save(createMenu(
                "Double Burger",
                "Double beef patties",
                new BigDecimal("99.99"),
                "burger4.jpg",
                burgers));

        // =========================
        // Drinks
        // =========================

        menuRepository.save(createMenu(
                "Coca-Cola",
                "330ml",
                new BigDecimal("19.99"),
                "coke.jpg",
                drinks));

        menuRepository.save(createMenu(
                "Sprite",
                "330ml",
                new BigDecimal("19.99"),
                "sprite.jpg",
                drinks));

        menuRepository.save(createMenu(
                "Orange Juice",
                "Fresh juice",
                new BigDecimal("29.99"),
                "juice.jpg",
                drinks));

        menuRepository.save(createMenu(
                "Chocolate Milkshake",
                "Creamy milkshake",
                new BigDecimal("39.99"),
                "shake.jpg",
                drinks));

        System.out.println("==================================");
        System.out.println("Sample data loaded successfully.");
        System.out.println("Categories: 3");
        System.out.println("Menus: 12");
        System.out.println("==================================");
    }

    private Menu createMenu(
            String name,
            String description,
            BigDecimal price,
            String imageUrl,
            Category category) {

        return Menu.builder()
                .name(name)
                .description(description)
                .price(price)
                .imageUrl(imageUrl)
                .category(category)
                .build();
    }
}
