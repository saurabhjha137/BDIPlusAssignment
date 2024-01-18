package com.todotask.assignment.todotask.services;

import com.todotask.assignment.todotask.entity.TodoTask;

import java.util.List;

public interface TodoService {
    TodoTask addTask(TodoTask todoTask);

    List<TodoTask> getAllTask();

    TodoTask getTaskById(int id);

    TodoTask updateTaskById(int id, TodoTask employee);

    String deleteTaskById(int id);
}
