package com.company;

import java.util.*;

public class SetIterator {
    public void printSet(int one, int two, int three, int four, int five){
        HashSet<Integer>printSet = new HashSet<>();
        printSet.add(one);
        printSet.add(two);
        printSet.add(three);
        printSet.add(four);
        printSet.add((five));

        Iterator<Integer> iter = printSet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }
    }






