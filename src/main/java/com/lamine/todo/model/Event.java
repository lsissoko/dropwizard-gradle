package com.lamine.todo.model;

public class Event {

    public long date;
    public String name;
    public long value;

    public Event(long date, String name, long value) {
        this.date = date;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Event{" + "date=" + date + ", name='" + name + '\'' + ", value=" + value + '}';
    }
}
