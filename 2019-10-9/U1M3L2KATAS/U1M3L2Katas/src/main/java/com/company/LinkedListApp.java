package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    public static int total (List<Integer> numbers ){

        int sum = 0;
        for(int num:numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.add(0, strings.get(strings.size() - 1));
        strings.add(strings.size()-1, temp);
        strings.remove(1);
        strings.remove(strings.size() - 1);

        return strings;
    }

    public static List<Integer> reverse(List<Integer> numbers) {

        Collections.reverse(numbers);

        return numbers;
    }

    public static List<Integer> lessThanFive(List<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        List<Integer> lessThan = new LinkedList<>();


        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThan.add(num);
                numLessThanFive--;
            }
        }

        return lessThan;
    }

}
