package com.todotask.assignment.todotask.services;

import com.todotask.assignment.todotask.entity.TodoTask;
import com.todotask.assignment.todotask.repositories.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoTaskService implements TodoService {

    @Autowired
    private TodoTaskRepository todoTaskRepository;

    @Override
    public TodoTask addTask(TodoTask todoTask) {
        return todoTaskRepository.save(todoTask);
    }

    @Override
    public List<TodoTask> getAllTask(){

        List<TodoTask> allTasks = todoTaskRepository.findAll();

        if (allTasks.isEmpty()) {
            throw new RuntimeException("Task List is Empty");
        }

        return allTasks;
    }

    @Override
    public TodoTask getTaskById(@PathVariable(name="id") int id){

        Optional<TodoTask> todo = todoTaskRepository.findById(id);
        if (todo.isPresent()){
            return todo.get();
        }
        throw new EntityNotFoundException("Task Not Found");
    }

    @Override
    public TodoTask updateTaskById(int id, TodoTask todoTask) {
        Optional<TodoTask> task1 = todoTaskRepository.findById(id);

        if (task1.isPresent()) {
            TodoTask originalTask = task1.get();

            if (Objects.nonNull(todoTask.getTaskName()) && !"".equalsIgnoreCase(todoTask.getTaskName())) {
                originalTask.setTaskName(todoTask.getTaskName());
            }
            if (Objects.nonNull(todoTask.getTaskDescription()) && !"".equalsIgnoreCase(todoTask.getTaskDescription())) {
                originalTask.setTaskDescription(todoTask.getTaskDescription());
            }

            System.out.println("Updated");
            return todoTaskRepository.save(originalTask);
        }

        throw new EntityNotFoundException("Task Not Found");
    }

    @Override
    public String deleteTaskById(int id) {
        if (todoTaskRepository.findById(id).isPresent()) {
            todoTaskRepository.deleteById(id);
            return "Task deleted successfully";
        }
        return "No such Task in the database";
    }


}

