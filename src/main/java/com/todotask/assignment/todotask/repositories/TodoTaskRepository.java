package com.todotask.assignment.todotask.repositories;

import com.todotask.assignment.todotask.entity.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer> {
}
