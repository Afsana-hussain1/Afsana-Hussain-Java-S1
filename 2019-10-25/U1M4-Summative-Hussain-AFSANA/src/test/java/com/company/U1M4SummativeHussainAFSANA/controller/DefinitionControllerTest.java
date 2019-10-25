package com.company.U1M4SummativeHussainAFSANA.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Definition;
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
@WebMvcTest(DefinitionController.class)

public class DefinitionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    //ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();
    // a list of Definitions for testing purposes
    private List<Definition> definitionList;

    @Before
    public void setUp() {
        //Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Automatic
        int idCounter = 1;
        definitionList = new ArrayList<>();


        definitionList.add(new Definition("physicist", "a scientist who specializes in physics.", idCounter++));
        definitionList.add(new Definition("intranet", "a computer network with restricted access, as within a company, that uses software and protocols developed for the Internet.", idCounter++));
        definitionList.add(new Definition("appoint", "to establish by agreement or decree; fixa time was appointed for the duel", idCounter++));
        definitionList.add(new Definition("paperback", "a book bound in a flexible paper cover, often a lower-priced edition of a hardcover book.", idCounter++));
        definitionList.add(new Definition("cohabit", "to live together as if married, usually without legal or religious sanction.", idCounter++));
        definitionList.add(new Definition("xerochilia", "Dryness of the lips.", idCounter++));
        definitionList.add(new Definition("dad joke", "a corny and generally unfunny joke reminiscent of the types of remarks made by middle-aged or elderly fathers to their children: ", idCounter++));
        definitionList.add(new Definition("fibreglass", "material consisting of matted fine glass fibres, used as insulation in buildings, in fireproof fabrics, etc", idCounter++));
        definitionList.add(new Definition("kawakawa", "an aromatic shrub or small tree of New Zealand, Macropiper excelsum: held to be sacred by the MāorisAlso called: peppertree", idCounter++));
        definitionList.add(new Definition("quaff", "to drink a beverage, especially an intoxicating one, copiously and with hearty enjoyment.", idCounter++));

    }

    @Test
    public void shouldReturnAllWordsWithDefinition() throws Exception {
        // ARRANGE
        //convert Java Object to Jso

        // ACT
        mockMvc.perform(get("/Word"))                 //perform get request
                .andDo(print())                               //print results to console
                .andExpect(status().isOk()) ;                    //ASSERT(status code

    }
}
