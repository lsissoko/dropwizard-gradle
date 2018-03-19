package com.lamine.todo.model;

public class Task {
    public String text;

    public Task(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Task{" + "text='" + text + '\'' + '}';
    }
}
