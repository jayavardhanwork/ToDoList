package com.example.todolist.controllers;

import com.example.todolist.model.Task;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    private ArrayList<Task> taskList = new ArrayList<>();
    @GetMapping("/")
    ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskList);
    }

    @PostMapping("/")
    ResponseEntity<Task> addNewTask(@RequestBody Task task){
        Task taskToAdd = new Task(task.getName(),task.getId());
        taskList.add(taskToAdd);
        return ResponseEntity.status(201).body(taskToAdd);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable int id){
        for (Task task:taskList) {
            if(task.getId() == id){
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Task> editTaskById(@PathVariable int id, @RequestBody String name){
        for (Task task:taskList) {
            if(task.getId() == id){
                task.setName(name);
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Task> deleteTaskById(@PathVariable int id){
        for (Task task:taskList) {
            if(task.getId() == id){
                taskList.remove(task);
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.status(404).body(null);
    }
    /**
     * assignment
     * 1. Get -> /tasks/3
     *              get task no 3
     *              if task does not exist send 404
     *              done
     * 2. patch -> /tasks/3
     *              update due date or done status
     *              send 404 error to client if task 3 does not exist
     *              done
     * 3. delete -> tasks/5
     *              delete task no 5 (response with correct http code)
     *              if task does not exist send 404
     *              done
     */
}
