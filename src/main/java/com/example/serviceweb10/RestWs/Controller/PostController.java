package com.example.serviceweb10.RestWs.Controller;

import com.example.serviceweb10.RestWs.Model.Post;
import com.example.serviceweb10.RestWs.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/posts")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("")
    public List<Post> getAllPosts(){
        return postService.getAll();
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PostMapping("/add")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PutMapping("/update/{id}")
    public Post updateTodo(@PathVariable Long id, @RequestBody Post post){
        return postService.updatePost(id, post);
    }


}
