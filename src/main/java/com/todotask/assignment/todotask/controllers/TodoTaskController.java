package com.todotask.assignment.todotask.controllers;

import com.todotask.assignment.todotask.entity.TodoTask;
import com.todotask.assignment.todotask.repositories.TodoTaskRepository;
import com.todotask.assignment.todotask.services.TodoTaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo-task/")
@AllArgsConstructor

public class TodoTaskController {

    @Autowired
    private TodoTaskService service;
    private TodoTaskRepository todoTaskRepository;


    @PostMapping("/addTask") //Create

    public TodoTask addTask(@RequestBody TodoTask todoTask){

        return service.addTask(todoTask);
    }

    @GetMapping("/getAllTask") // Read All

    public List<TodoTask> getAllTask(){

        return service.getAllTask();
    }

    @GetMapping("/getTaskBy/{id}") //Read

    public TodoTask getById(@PathVariable(name="id") int id){

        return service.getTaskById(id);
    }

    @PutMapping("/updateTask/{id}") //Update

    public TodoTask updateTaskById(@PathVariable("id") int id, @RequestBody TodoTask todoTask){

        return service.updateTaskById(id, todoTask);
    }


    @DeleteMapping("/deleteTask/{id}") // Delete

    public String deleteTaskById(@PathVariable(name="id") int id){

        return service.deleteTaskById(id);
    }


}
