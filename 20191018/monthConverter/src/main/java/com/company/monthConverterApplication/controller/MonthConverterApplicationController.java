package com.company.monthConverterApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterApplicationController {

    @RequestMapping(value = "/month/{monthNumber}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int month(@PathVariable int input) {
    if (input < 1 || input > 12) {
        throw new IllegalArgumentException("Input must be between 1 and 12");
    }
        return input;
}
}
