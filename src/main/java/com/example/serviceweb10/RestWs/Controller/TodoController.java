package com.example.serviceweb10.RestWs.Controller;

import com.example.serviceweb10.RestWs.Model.Todo;
import com.example.serviceweb10.RestWs.Service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @GetMapping("")
    public List<Todo> getAllTodos(){
        return todoService.getAll();
    }
    @GetMapping("/{id}")
    public Todo getPostById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }

    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }

    @PutMapping("/update/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

}
