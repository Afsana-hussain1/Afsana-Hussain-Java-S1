package com.company.U1M4SummativeHussainAFSANA.controller;

import models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {


    private List<Definition> definitionList;
    private static int idCounter = 1;

    public DefinitionController() {
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

        @RequestMapping(value = "/Word", method = RequestMethod.GET)
        @ResponseStatus(value = HttpStatus.OK)
        public Definition getDefinition() {

            Random generateRand = new Random();
            return definitionList.get(generateRand.nextInt(10));
        }
    }





