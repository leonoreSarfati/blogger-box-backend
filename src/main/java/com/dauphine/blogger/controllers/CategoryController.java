package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.dto.UpdateCategoryRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
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

    private final List<Category> temporaryCategories;

    public CategoryController(){
        temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category(UUID.randomUUID(), "my first category"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "my second category"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "my third category"));
    }

    @GetMapping("")
    @Operation(
            summary = "Get all categories"
    )
    public List<Category> getAllCategories(){
        return temporaryCategories;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get category by id"
    )
    public Category getCategoryByID(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id){
        //TODO
        return temporaryCategories.get(0);
    }

    @PostMapping("")
    @Operation(
            summary = "Create new category"
    )
    public String createCategory(
            @Parameter(description = "Object with the neesary parameters to update a category")
            @RequestBody CreationCategoryRequest body){
        //TODO
        return "Create new element with name " + body.getName();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update name category"
    )
    public String updateCategory(
            @Parameter(description = "Id of the category to update")
            @PathVariable UUID id,
            @Parameter(description = "Object with the needed parameters to create a new category")
            @RequestBody UpdateCategoryRequest body){
        //TODO
        return "Update name of category with id " + id;
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete category"
    )
    public String deleteCategory(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id){
        //TODO
        return "Delete category with id " + id;
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
