package com.example.serviceweb10.RestWs.Service;

import com.example.serviceweb10.RestWs.Model.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    private final RestTemplate restTemplate = new RestTemplate();


    public List<Post> getAll() {
        ResponseEntity<List> posts = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/", List.class);
        return posts.getBody();
    }

    public Post getPostById(Long id){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Post> post = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/"+id,Post.class);
        return post.getBody();
    }

    public Post addPost(Post post){
        RestTemplate restTemplate=new RestTemplate();
        HttpEntity<Post> request=new HttpEntity<>(post);
        ResponseEntity<Post> res =restTemplate.postForEntity("https://jsonplaceholder.typicode.com/posts/",request,Post.class);

        return  res.getBody();
    }
    public void deletePost(Long id){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/"+id);
    }

    public Post updatePost(Long id, Post post){
        HttpEntity<Post> request=new HttpEntity<>(post);
        restTemplate.put("https://jsonplaceholder.typicode.com/posts/"+id,request,Post.class);
        return request.getBody();
    }
}
