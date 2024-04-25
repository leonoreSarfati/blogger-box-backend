package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.dto.UpdateCategoryRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
@Tag(
        name="Categories",
        description = "All endpoints regarding categories"
)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("")
    @Operation(
            summary = "Get all categories"
    )
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get category by id"
    )
    public Category getCategoryByID(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id){
        return categoryService.getById(id);
    }

    @PostMapping("")
    @Operation(
            summary = "Create new category"
    )
    public Category createCategory(
            @Parameter(description = "Object with the neesary parameters to update a category")
            @RequestBody String name){
        return categoryService.create(name);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update name category"
    )
    public Category updateCategory(
            @Parameter(description = "Id of the category to update")
            @PathVariable UUID id,
            @Parameter(description = "Object with the needed parameters to create a new category")
            @RequestBody String name){
        return categoryService.update(id,name);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete category"
    )
    public void deleteCategory(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id){
        categoryService.deleteById(id);
    }

    @GetMapping("/{id}/posts")
    @Operation(
            summary = "Get all posts for a certain category"
    )
    public List<Post> getPostsForACategory(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id){
        //TODO
        return new ArrayList<>();
    }





}
