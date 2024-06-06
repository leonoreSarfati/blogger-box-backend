package com.dauphine.blogger.repositories;

import com.dauphine.blogger.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("""
            SELECT c
            FROM Category c
            WHERE c.name LIKE CONCAT('%', :name, '%')
            """)
    List<Category> findAllByName(@Param("name") String name);

    Category findByName(String name);

    Boolean existsByName(String name);
}
