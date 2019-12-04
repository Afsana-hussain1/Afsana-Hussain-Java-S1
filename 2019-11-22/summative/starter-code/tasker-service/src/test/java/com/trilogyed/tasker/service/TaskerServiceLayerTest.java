package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

   @Mock
    TaskerDao taskerDao;

    @Autowired
    AdClient adClient;


    Task task = new Task();
    Task task1 = new Task();

    @Before
    public void setUp() throws Exception{
        setUpClientMock();
        setTaskerDaoMock();
        service = new TaskerServiceLayer(taskerDao, adClient);


    }
    private void setTaskerDaoMock() {

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);


        task.setId(1);
        task.setCreateDate(LocalDate.of(2019,10,01));
        task.setDescription("taskk");
        task.setDueDate(LocalDate.of(2020,02,19));
        task.setCategory("fun");


        task1.setCreateDate(LocalDate.of(2019,10,01));
        task1.setDescription("taskk");
        task.setDueDate(LocalDate.of(2020,02,19));
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

        Task task = new Task();
        task.setCreateDate(LocalDate.of(2019,10,01));
        task.setDescription("taskk");
        task.setDueDate(LocalDate.of(2020,02,19));
        task.setCategory("fun");

        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setAdvertisement("bla");

        task =taskerDao.createTask(task);


        TaskViewModel taskViewModel2 ;

        taskViewModel2 = service.fetchTask(0);
        assertEquals(taskViewModel,taskViewModel2);

    }

    //couldnt figure out why mockito wasnt working.





}