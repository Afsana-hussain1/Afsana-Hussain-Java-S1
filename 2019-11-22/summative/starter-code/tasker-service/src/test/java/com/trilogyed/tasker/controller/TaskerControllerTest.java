package com.trilogyed.tasker.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.tasker.TaskerServiceApplication;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdClient;
import javafx.beans.binding.When;
import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(TaskerController.class)
public class TaskerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TaskerServiceLayer taskerServiceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Mock
    AdClient adClient;

    TaskViewModel inputtask = new TaskViewModel();
    TaskViewModel outputTask = new TaskViewModel();

    @Before
      public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(adClient.adv()).thenReturn("some ad");


        inputtask.setCategory("cat");
        inputtask.setDescription("descrip");


        outputTask.setId(1);
        outputTask.setCategory("cat");
        outputTask.setDescription("descrip");
        outputTask.setAdvertisement("some ad");
        when(taskerServiceLayer.newTask(inputtask)).thenReturn(outputTask);


    }

   //testing get/ task
   @Test
    public void createTask_shouldCreateTaskWithId() throws Exception {



    String inputJson = mapper.writeValueAsString(inputtask);


    String outputJson = mapper.writeValueAsString(outputTask);

    //Act
    mockMvc.perform(post("/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(inputJson)
    )
            .andDo(print())
            //Assert
            .andExpect(status().isCreated())
            .andExpect(content().json(mapper.writeValueAsString(outputTask)));







}






}
