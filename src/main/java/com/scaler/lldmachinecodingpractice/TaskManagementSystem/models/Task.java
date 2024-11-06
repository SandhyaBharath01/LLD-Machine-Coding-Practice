package com.scaler.lldmachinecodingpractice.TaskManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Task {
    private String taskId;
    private String taskTitle;
    private String taskDescription;
    private Date dueDate;
    private int priority;
    private TaskStatus taskStatus;
    private User assignedUser;

    public Task(final String taskId, final String taskTitle, final String taskDescription, final Date dueDate, final int priority, User assignedUser) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignedUser = assignedUser;
        this.taskStatus = TaskStatus.PENDING;
    }
}
