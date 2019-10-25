package com.company.U1M4SummativeHussainAFSANA.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Answer;
import models.Definition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    //ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private List<Answer> answerList;

    @Before
    public void setUp() {
        //Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Automatic
        int idCounter = 1;
        answerList = new ArrayList<>();


        answerList.add(new Answer("yes. your Significant other ", "Will I have children in the future.", idCounter++));
        answerList.add(new Answer("I dont think you want the answer to that ", "How long will I live till?", idCounter++));
        answerList.add(new Answer("probably Not.", "Will I ever fall in love", idCounter++));
        answerList.add(new Answer("No comment.", "Will I ever get better at java", idCounter++));
        answerList.add(new Answer("Who even purchases those anymore", "How many licks does it take to get to the center of a tootsie pop", idCounter++));
        answerList.add(new Answer("six figures..of poop", "How much money will I make in the future", idCounter++));
    }
        @Test
        public void shouldReturnRandomAnswer() throws Exception {

            Answer answer = new Answer();
            answer.setAnswer("I dont think you want the answer to that ");
            answer.setQuestion("How long will I live till?");

            String inputJson = mapper.writeValueAsString(answer);
            // ACT
            mockMvc.perform(post("/magic")
                    .content(inputJson)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())                               //print results to console
                    .andExpect(status().isCreated()) ;

        }

    }
