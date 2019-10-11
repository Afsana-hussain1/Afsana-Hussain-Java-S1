package com.company;

import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {
     ConverterIf ifStatement = new ConverterIf();
     ConverterSwitch switchStatement = new ConverterSwitch();
      ifStatement.convertDay(1);
      ifStatement.convertMonth(3);
      switchStatement.convertDay(6);
      switchStatement.convertMonth(11);
    }
}
