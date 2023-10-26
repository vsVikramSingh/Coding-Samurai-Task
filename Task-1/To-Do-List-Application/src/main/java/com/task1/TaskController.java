package com.task1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private List<Task> tasks = new ArrayList<>();

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @PostMapping("/complete/{index}")
    public Task markTaskAsComplete(@PathVariable int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            return task;
        }
        return null;
    }

    @GetMapping("/list")
    public List<Task> listTasks() {
        return tasks;
    }

    @DeleteMapping("/remove/{index}")
    public Task removeTask(@PathVariable int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.remove(index);
        }
        return null;
    }
}
