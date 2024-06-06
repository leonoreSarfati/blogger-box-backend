package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.exceptions.PostNotFoundByIdException;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
@Tag(
        name="Posts",
        description = "All endpoints regarding posts"
)
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    @Operation(
            summary = "Get all categories"
    )
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.getAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get post by id"
    )
    public ResponseEntity<Post> getPostByID (
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id) throws PostNotFoundByIdException {
        Post post = postService.getById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping("")
    @Operation(
            summary = "Create new post"
    )
    public ResponseEntity<Post> createPost(
            @Parameter(description = "Object with the necessary parameters to create a new post")
            @RequestBody CreationPostRequest body) throws CategoryNotFoundByIdException {
        Post post = postService.create(body.getTitle(), body.getContent(), body.getCategoryId());
        return ResponseEntity
                .created(URI.create("v1/posts/" + post.getId()))
                .body(post);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update post"
    )
    public ResponseEntity<Post> updatePost(
            @Parameter(description = "Id of the post to update")
            @PathVariable UUID id,
            @Parameter(description = "Object with the necessary parameters to update a new post")
            @RequestBody UpdatePostRequest body) throws PostNotFoundByIdException {
        Post post = postService.update(id, body.getTitle(), body.getContent());
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a post"
    )
    public ResponseEntity<Post> deletePost(
            @Parameter(description = "Id of the post to delete")
            @PathVariable UUID id){
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
