package com.company.U1M4SummativeHussainAFSANA.controller;

import models.Definition;
import models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
private List<Quote> quoteList;
private static int idCounter = 1;

public QuoteController() {
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
        @RequestMapping(value = "/quote", method = RequestMethod.GET)
        @ResponseStatus(value = HttpStatus.OK)
        public Quote getQuote() {

            Random generateRand = new Random();
            return quoteList.get(generateRand.nextInt(10));
        }
    }


