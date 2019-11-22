package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerServiceLayerTest {


    @Autowired
    TaskerServiceLayer service;

    TaskerDao taskerDao;

    AdClient adClient;


    @Before
    public void setUp() throws Exception{
        setUpClientMock();
        setTaskerDaoMock();
        service = new TaskerServiceLayer(taskerDao, adClient);


    }
    private void setTaskerDaoMock() {

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setCreateDate(LocalDate.of(2019,10,01));
        task.setDescription("taskk");
        task.setDueDate(LocalDate.of(2020,02,19));
        task.setCategory("fun");

        Task task1 = new Task();

        task1.setCreateDate(LocalDate.of(2019,10,01));
        task1.setDescription("taskk");
        task.setCreateDate(LocalDate.of(2020,02,19));
        task1.setCategory("fun");



        List<Task>taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(taskList).when(taskerDao).getTasksByCategory("fun");
    }


    private void setUpClientMock(){
        adClient = mock(AdClient.class);
        when(adClient.adv()).thenReturn("bla");

    }


    @Test
    public void shouldSaveandFindTask(){

        TaskViewModel task = new TaskViewModel();
        task.setCreateDate(LocalDate.of(2019,10,01));
        task.setDescription("taskk");
        task.setCreateDate(LocalDate.of(2020,02,19));
        task.setCategory("fun");

        task =service.newTask(task);

        TaskViewModel task1 = service.fetchTask(task.getId());
        assertEquals(task1,task);

    }

    //couldnt figure out why mockito wasnt working.





}