package com.company.U1M4SummativeHussainAFSANA.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Quo;
import models.Definition;
import models.Quote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {
@Autowired
    private MockMvc mockMvc;

 private ObjectMapper mapper = new ObjectMapper();

    private List<Quote> quoteList;
    // a list of Definitions for testing purposes;

    @Before
    public void setUp() {
        //Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Automatic
        int idCounter = 1;
        quoteList = new ArrayList<>();


        quoteList.add(new Quote("Rodney Dangerfield", "I haven't spoken to my wife in years. I didn't want to interrupt her", idCounter++));
        quoteList.add(new Quote("James A. Garfield", "I was eating in a Chinese restaurant downtown. There was a dish called Mother and Child Reunion. It's chicken and eggs. And I said, I gotta use that one", idCounter++));
        quoteList.add(new Quote("James A. Garfield", "Man cannot live by bread alone; he must have peanut butter.", idCounter++));
        quoteList.add(new Quote("Albert Einstein", "When you are courting a nice girl an hour seems like a second. When you sit on a red-hot cinder a second seems like an hour. That's relativity.", idCounter++));
        quoteList.add(new Quote("Henry Kissinger", "There cannot be a crisis next week. My schedule is already full.", idCounter++));
        quoteList.add(new Quote("Saint Augustine", "O Lord, help me to be pure, but not yet.", idCounter++));
        quoteList.add(new Quote("Marcelene Cox", "If at first you don't succeed, blame your parents.", idCounter++));
        quoteList.add(new Quote("Franklin P. Jones", "One advantage of talking to yourself is that you know at least somebody's listening..", idCounter++));
        quoteList.add(new Quote("Ralph Waldo Emerson", "Common sense is genius dressed in its working clothes.", idCounter++));
        quoteList.add(new Quote("Bruce Lee", "A foolish consistency is the hobgoblin of little minds, adored by little statesmen and philosophers and divines.", idCounter++));

    }

    @Test
    public void shouldReturnAllQuotesWithAuthors() throws Exception {
        // ARRANGE
        //convert Java Object to Jso

        // ACT
        mockMvc.perform(get("/quote"))                 //perform get request
                .andDo(print())                               //print results to console
                .andExpect(status().isOk()) ;                    //ASSERT(status code

    }
}



