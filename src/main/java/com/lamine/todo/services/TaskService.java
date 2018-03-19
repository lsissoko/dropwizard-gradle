package com.lamine.todo.services;

import com.lamine.todo.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    public void add(String text) {
        tasks.add(new Task(text));
    }

    public List<Task> getAll() {
        return tasks;
    }

    public void clear() {
        tasks = new ArrayList<>();
    }
}
