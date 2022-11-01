package com.example.todolist.model;

import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Task {
    private String name;
    private LocalDate due;
    private boolean done;
    private int id;

    /**
     * create a task object with given task string
     * due date 5 days from now, and done = false
     * @param name
     */

    public Task(String name,int id){
        this(name, LocalDate.now().plus(5, ChronoUnit.DAYS), false,id);
    }


}
