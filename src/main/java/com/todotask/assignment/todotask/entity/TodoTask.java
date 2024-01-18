package com.todotask.assignment.todotask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="task_list")
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id")
    private int taskId;

    @Column(name="task_name")
    private String taskName;

    @Column(name="task_description")
    private String taskDescription;

    @Column(name="is_completed")
    private boolean isCompleted;


}
