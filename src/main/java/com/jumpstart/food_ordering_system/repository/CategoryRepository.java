package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsible for interacting
 * with the database.
 */

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
