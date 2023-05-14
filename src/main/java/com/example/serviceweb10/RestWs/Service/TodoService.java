package com.example.serviceweb10.RestWs.Service;

import com.example.serviceweb10.RestWs.Model.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Todo> getAll() {
        ResponseEntity<List> todos = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/", List.class);
        return todos.getBody();
    }

    public Todo getTodoById(Long id){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Todo>todo=restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/"+id,Todo.class);
        return todo.getBody();
    }

    public Todo addTodo(Todo todo){
        RestTemplate restTemplate=new RestTemplate();
        HttpEntity<Todo> request=new HttpEntity<>(todo);
        ResponseEntity<Todo> res =restTemplate.postForEntity("https://jsonplaceholder.typicode.com/todos/",request,Todo.class);

        return  res.getBody();
    }
    public void deleteTodo(Long id){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete("https://jsonplaceholder.typicode.com/todos/"+id);
    }

    public Todo updateTodo(Long id, Todo todo){
        HttpEntity<Todo> request=new HttpEntity<>(todo);
        restTemplate.put("https://jsonplaceholder.typicode.com/todos/"+id,request,Todo.class);
        return request.getBody();
    }
}
