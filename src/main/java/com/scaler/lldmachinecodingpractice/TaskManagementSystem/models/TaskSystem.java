package com.scaler.lldmachinecodingpractice.TaskManagementSystem.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskSystem {
    private static TaskSystem instance;
    private Map<String, Task> tasks;
    private Map<String, List<Task>> userTasks;

    public TaskSystem(){
        tasks = new ConcurrentHashMap<>();
        userTasks = new ConcurrentHashMap<>();
    }
    public static synchronized TaskSystem getInstance(){
        if(instance==null){
            instance = new TaskSystem();
        }
        return instance;
    }

    public void createTask(Task task) {
        tasks.put(task.getTaskId(), task);
        assignTaskToUser(task.getAssignedUser(), task);
    }

    public void updateTask(Task updatedTask){
        Task existingTask = tasks.get(updatedTask.getTaskId());
        if(existingTask!=null){
            synchronized (existingTask) {
                existingTask.setTaskStatus(updatedTask.getTaskStatus());
                existingTask.setTaskDescription(updatedTask.getTaskDescription());
                existingTask.setTaskTitle(updatedTask.getTaskTitle());
                existingTask.setDueDate(updatedTask.getDueDate());
                existingTask.setPriority(updatedTask.getPriority());

                User prevUser = existingTask.getAssignedUser();
                User newUser = updatedTask.getAssignedUser();
                if(prevUser!=newUser){
                    unassignedTaskFromUser(prevUser,existingTask);
                    assignTaskToUser(newUser,existingTask);
                }
            }
        }
    }
    public void deleteTask(String taskId){
        Task task = tasks.remove(taskId);
        if(task!=null) {
            unassignedTaskFromUser(task.getAssignedUser(),task);
        }

    }

    public List<Task> searchTask(String keyword){
        List<Task> matchedTasks = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.getTaskTitle().contains(keyword) || task.getTaskDescription().contains(keyword)){
                matchedTasks.add(task);
            }
        }
        return matchedTasks;
    }
    public List<Task> filterTask(TaskStatus status){
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.getTaskStatus().equals(status)){
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void markAsCompleted(String taskId){
        Task task = tasks.get(taskId);
        if(task!=null){
            synchronized (task){
                task.setTaskStatus(TaskStatus.COMPLETED);
            }
        }

    }

    public List<Task> getTaskHistory(User user){
        return new ArrayList<>(userTasks.getOrDefault(user.getId(),new ArrayList<>()));
    }
    public void assignTaskToUser(User user, Task task){
        //computeIfAbsent checks if userTasks already has a list for the user's ID.
        userTasks.computeIfAbsent(user.getId(), x -> new CopyOnWriteArrayList<>()).add(task);
    }
    public void unassignedTaskFromUser(User user, Task task){
        List<Task> tasks = userTasks.get(user.getId());
        if(tasks!=null){
            tasks.remove(task);
        }
    }

}
