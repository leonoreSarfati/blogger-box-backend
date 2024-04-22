package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdateCategoryRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.models.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
@Tag(
        name="Posts",
        description = "All endpoints regarding posts"
)
public class PostController {

    @PostMapping("")
    @Operation(
            summary = "Create new post"
    )
    public String createPost(
            @Parameter(description = "Object with the necessary parameters to create a new post")
            @RequestBody CreationPostRequest body){
        //TODO
        return "Create new post with name " + body.getTitle();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update post"
    )
    public String updatePost(
            @Parameter(description = "Id of the post to update")
            @PathVariable UUID id,
            @Parameter(description = "Object with the necessary parameters to update a new post")
            @RequestBody UpdatePostRequest body){
        //TODO
        return "Update post with id " + id;
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a post"
    )
    public String deletePost(
            @Parameter(description = "Id of the post to delete")
            @PathVariable UUID id){
        //TODO
        return "Delete post with id " + id;
    }

    @GetMapping("")
    @Operation(
            summary = "Posts ordered by creation date"
    )
    public List<Post> getPostsOrderedByDate(){
        //TODO
        return new ArrayList<>();
    }

}
