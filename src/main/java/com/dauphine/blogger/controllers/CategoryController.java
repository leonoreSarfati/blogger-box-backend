package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.dto.UpdateCategoryRequest;
import com.dauphine.blogger.exceptions.CategoryNameAlreadyExistsException;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.exceptions.CategoryNotFoundByNameException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    /*@GetMapping
    @Operation(
            summary = "Get all categories"
    )
    public List<Category> getAllCategories(@RequestParam String name){
        return name==null || name.isBlank()
                ? categoryService.getAll()
                : categoryService.getAllByName(name);
    }*/

    @GetMapping
    @Operation(
            summary = "Get categories by name"
    )
    public List<Category> getAllCategories(@RequestParam String name) throws CategoryNotFoundByNameException {
        return categoryService.getAllByName(name);
    }

    @GetMapping
    @Operation(
            summary = "Get all categories"
    )
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories= categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get category by id"
    )
    public ResponseEntity<Category> getCategoryByID (
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id) throws CategoryNotFoundByIdException {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("")
    @Operation(
            summary = "Create new category"
    )
    public ResponseEntity<Category> createCategory(
            @Parameter(description = "Object with the neesary parameters to update a category")
            @RequestBody String name) throws CategoryNameAlreadyExistsException {
        Category category = categoryService.create(name);
        return ResponseEntity
                .created(URI.create("v1/categories/" + category.getId()))
                .body(category);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update name category"
    )
    public ResponseEntity<Category> updateCategory(
            @Parameter(description = "Id of the category to update")
            @PathVariable UUID id,
            @Parameter(description = "Object with the needed parameters to create a new category")
            @RequestBody String name) throws CategoryNotFoundByIdException, CategoryNameAlreadyExistsException {
        Category category = categoryService.update(id,name);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete category"
    )
    public ResponseEntity<Category> deleteCategory(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
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
