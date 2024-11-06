package com.scaler.lldmachinecodingpractice.TaskManagementSystem;

import com.scaler.lldmachinecodingpractice.TaskManagementSystem.models.Task;
import com.scaler.lldmachinecodingpractice.TaskManagementSystem.models.TaskStatus;
import com.scaler.lldmachinecodingpractice.TaskManagementSystem.models.TaskSystem;
import com.scaler.lldmachinecodingpractice.TaskManagementSystem.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        TaskSystem ts = TaskSystem.getInstance();
        Scanner scn = new Scanner(System.in);

        User user1 = new User("1", "Sandhya", "sandhya@gmail.com");
        User user2 = new User("2", "Bharath", "bharath@gmail.com");
        //create task
        Task task1 = new Task("1", "LLD Cont", "Complete LLD Contest", new Date(), 1, user1);
        Task task2 = new Task("2", "LLD Mock", "Complete LLD Mock Interview", new Date(), 2, user2);

        ts.createTask(task1);
        ts.createTask(task2);

        System.out.println("Enter Task name you want to search");
        String keyword = scn.nextLine();

        //mark task as completed
        ts.markAsCompleted("1");
        //show tasks
        List<Task> searchResults = ts.searchTask(keyword);
        System.out.println("Search Results");
        if(searchResults.isEmpty()){
            System.out.println("No tasks found");
        }else {
            for (Task task : searchResults) {
                System.out.println(task.getTaskTitle());
            }
        }
        //update Task
        System.out.println("Do you want to update task(Yes/no)");
        String taskUpdate = scn.nextLine();
        System.out.println("Enter Task Id");
        String taskId = scn.nextLine();
        if(taskUpdate.equalsIgnoreCase("yes") && taskId.equalsIgnoreCase("1")) {
            task1.setTaskDescription("Task1 updated");
            ts.updateTask(task1);
            System.out.println("Task1 updated as " + task1.getTaskDescription());
        }
        if(taskUpdate.equalsIgnoreCase("yes") && taskId.equalsIgnoreCase("2")) {
            task2.setTaskDescription("Task2 updated");
            ts.updateTask(task2);
            System.out.println("Task2 updated as "+task2.getTaskDescription());
        }
        if(taskUpdate.equalsIgnoreCase("no")){
            System.out.println("Nothing got updated");
            return;
        }

        //filter tasks
        System.out.println("Enter TaskStatus to filter");
        String taskStatus = scn.nextLine();
        List<Task> filteredTasks = ts.filterTask(TaskStatus.valueOf(taskStatus));
        System.out.println("Filtered tasks");
        for(Task task : filteredTasks){
            System.out.println(task.getTaskTitle());
        }

        List<Task> taskHistory = ts.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTaskTitle());
        }

        // Delete a task
        System.out.println("Enter taskId delete a task");
        String taskIdToDelete = scn.nextLine();
        ts.deleteTask(taskIdToDelete);
        System.out.println("Task with taskId " +taskIdToDelete+" has been deleted");
        scn.close();
    }
}
