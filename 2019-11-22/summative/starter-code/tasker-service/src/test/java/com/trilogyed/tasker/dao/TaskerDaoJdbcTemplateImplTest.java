package com.trilogyed.tasker.dao;


import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {

        //clean out test db
        List<Task>taskList =taskerDao.getAllTasks();

        taskList.stream()
                .forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    @Test
    public void addGetDeleteTask(){
        Task task = new Task();
        task.setCategory("category");
        task.setCreateDate(LocalDate.of(2012,12,10));
        task.setDescription("descrip");
        task.setDueDate(LocalDate.of(2010,12,12));

        task = taskerDao.createTask(task);

        Task task1 =taskerDao.getTask(task.getId());

        assertEquals(task,task1);

        taskerDao.deleteTask(task.getId());

        task1 =taskerDao.getTask(task.getId());

        assertNull(task1);


    }

    @Test
    public void UpdateTask(){
        Task task = new Task();
        task.setCategory("category");
        task.setCreateDate(LocalDate.of(2019,12,10));
        task.setDescription("description");
        task.setDueDate(LocalDate.of(2020,12,10));

        task =taskerDao.createTask(task);

        task.setDescription("new descrip");

       taskerDao.updateTask(task);


    }

    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setCategory("category");
        task.setCreateDate(LocalDate.of(2020,10,1));
        task.setDescription("description");
        task.setDueDate(LocalDate.of(2021,12,12));

        task = taskerDao.createTask(task);

        Task task1 = new Task();
        task1.setCategory("category");
        task1.setCreateDate(LocalDate.of(2020,10,1));
        task1.setDescription("description");
        task1.setDueDate(LocalDate.of(2021,12,12));

        task1 =taskerDao.createTask(task1);

        List<Task>taskList =taskerDao.getAllTasks();

        assertEquals(2,taskList.size());


    }
    @Test
    public void getTasksByCategory(){
        Task task = new Task();
        task.setCategory("cat");
        task.setCreateDate(LocalDate.of(2012,12,12));
        task.setDescription("hey");
        task.setDueDate(LocalDate.of(2020,12,12));

        task = taskerDao.createTask(task);

        Task task1 = new Task();
        task1.setCategory("cat");
        task1.setCreateDate(LocalDate.of(2020,12,2));
        task1.setDescription("des");
        task1.setDueDate(LocalDate.of(2021,12,12));

        task1 =taskerDao.createTask(task1);

        List<Task>taskList = taskerDao.getTasksByCategory("cat");

        assertEquals(2,taskList.size());
    }
}
