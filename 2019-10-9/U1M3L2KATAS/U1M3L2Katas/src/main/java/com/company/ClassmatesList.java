package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {


    private List <Classmates> classmates = new ArrayList<>();
    public void add(Classmates classmates){
        this.classmates.add(classmates);

    }
    public Classmates get(int num){
        return this.classmates.get(num);
    }
    public List getAll (){
        return this.classmates;
    }
}


