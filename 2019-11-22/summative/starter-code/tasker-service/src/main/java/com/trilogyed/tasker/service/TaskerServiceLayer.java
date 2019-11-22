package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskerServiceLayer {

    TaskerDao dao;


    public final AdClient client;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdClient client) {
        this.dao = dao;
        this.client = client;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(client.adv());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = dao.getAllTasks();

        List<TaskViewModel> tList = new ArrayList<>();

        for (Task task : taskList) {
            TaskViewModel tvm = buildTaskViewModel(task);
            tList.add(tvm);

        }

        return tList;

    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
   return null;

    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task = dao.createTask(task);
        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(client.adv());
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }


    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task.setId(taskViewModel.getId());
        dao.updateTask(task);
    }
    private TaskViewModel buildTaskViewModel(Task task){
        TaskViewModel task1 = new TaskViewModel();
        task1.setId(task.getId());
        task1.setCategory(task.getCategory());
        task1.setCreateDate(task.getCreateDate());
        task1.setDescription(task.getDescription());
        task1.setDueDate(task.getDueDate());

        return task1;

    }
}
