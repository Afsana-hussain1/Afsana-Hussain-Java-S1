package com.company.U1M4SummativeHussainAFSANA.controller;

import models.Answer;
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
public class AnswerController {

    private List<Answer> answerList;
    private static int idCounter = 1;

    public AnswerController() {
        answerList = new ArrayList<>();


        answerList.add(new Answer("yes. your Significant other ", "Will I have children in the future.", idCounter++));
        answerList.add(new Answer("I dont think you want the answer to that ", "How long will I live till?", idCounter++));
        answerList.add(new Answer("probably Not.", "Will I ever fall in love", idCounter++));
        answerList.add(new Answer("No comment.", "Will I ever get better at java", idCounter++));
        answerList.add(new Answer("Who even purchases those anymore", "How many licks does it take to get to the center of a tootsie pop", idCounter++));
        answerList.add(new Answer("six figures..of poop", "How much money will I make in the future", idCounter++));
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getAnswer() {

        Random generateRand = new Random();
        return answerList.get(generateRand.nextInt(6));
    }
}



