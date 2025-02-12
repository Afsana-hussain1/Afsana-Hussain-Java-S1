 package com.company;

 import org.junit.Before;
 import org.junit.Test;

 import java.util.ArrayList;

 import static org.junit.Assert.assertEquals;

 public class ClassmatesListTest {

     private static ClassmatesList classmatesList;

     @Before
     public void resetList() {
         classmatesList = new ClassmatesList();
     }

     @Test
     public void shouldCreateAndAddClassmates() {
         Classmates one = new Classmates();
         one.setName("Fred");
         one.setHairColor("Brown");

         Classmates two = new Classmates();
         two.setName("Bruce");
         two.setHairColor("Blond");

         classmatesList.add(one);
         classmatesList.add(two);
     }

     @Test
     public void shouldGetClassmatesByIndex() {
         Classmates one = new Classmates();
         one.setName("Fred");
         one.setHairColor("Brown");

         Classmates two = new Classmates();
         two.setName("Bruce");
         two.setHairColor("Blond");

         classmatesList.add(one);
         classmatesList.add(two);

         String failMessage = "Expected to be able to get classmate by index";
         assertEquals(failMessage, "Fred", classmatesList.get(0).getName());
         assertEquals(failMessage, "Bruce", classmatesList.get(1).getName());
     }

     @Test
     public void shouldReturnAllClassmates() {
         Classmates one = new Classmates();
         one.setName("Fred");
         one.setHairColor("Brown");

         Classmates two = new Classmates();
         two.setName("Bruce");
         two.setHairColor("Blond");

         Classmates three = new Classmates();
         two.setName("Yoon");
         two.setHairColor("Black");

         classmatesList.add(one);
         classmatesList.add(two);
         classmatesList.add(three);

         ArrayList<Classmates> testList = new ArrayList<>();

         testList.add(one);
         testList.add(two);
         testList.add(three);

         String failMessage = "Expected to be able to get classmate by index";
         assertEquals(failMessage,  3, classmatesList.getAll().size());
         assertEquals(failMessage, testList, classmatesList.getAll());
     }
 }
