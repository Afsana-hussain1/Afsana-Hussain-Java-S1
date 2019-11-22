package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskerController {

    TaskerServiceLayer service;

    @Autowired
    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel taskViewModel) {
        return service.newTask(taskViewModel);
    }



    @GetMapping("/{id}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable(value = "id") int taskId) {
        TaskViewModel task = service.fetchTask(taskId);
        if (task == null)
            throw new IllegalArgumentException("task could not be retrieved for id " + taskId);
        return task;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){

        return service.fetchAllTasks();
    }



    @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable(value = "id") int id) {
        service.deleteTask(id);
    }




    @PutMapping("/{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable(value = "id") int taskId, @RequestBody @Valid TaskViewModel task) {
        if (task.getId() == 0)
            task.setId(taskId);
        if (taskId != task.getId()) {
            throw new IllegalArgumentException("Task ID on path must match the ID in the task object");
        }
   //     service.updateTask(task);
    }

}
