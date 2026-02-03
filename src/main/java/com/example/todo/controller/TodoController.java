package com.example.todo.controller;

import com.example.todo.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private Map<Long, Todo> todoStore = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    @GetMapping
    public Collection<Todo> getAllTodos() {
        return todoStore.values();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        Long id = counter.incrementAndGet();
        todo.setId(id);
        todoStore.put(id, todo);
        return todo;
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoStore.remove(id);
        return "Deleted todo with id: " + id;
    }
}
