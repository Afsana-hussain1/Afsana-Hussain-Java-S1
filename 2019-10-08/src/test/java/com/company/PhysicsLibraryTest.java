package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;




public class PhysicsLibraryTest {

  PhysicsLibrary physicsLibrary;

  @Before
  public void setUp() {
    physicsLibrary = new PhysicsLibrary();
  }


  @Test
  public void shouldFindForceOfTwoPositiveDoubles() {
    assertEquals(200d, physicsLibrary.calculateForce(10.0d, 20.0d), .1d);
    assertEquals(33d, physicsLibrary.calculateForce(5.5d, 6d), .1d);
    assertEquals(85.25d, physicsLibrary.calculateForce(15.5d, 5.5d), .1d);


  }

  @Test
  public void shouldFindForceOfOnePositiveOneNegativeDouble() {
    assertEquals(-200, physicsLibrary.calculateForce(-10.0, 20.0), .1d);
    assertEquals(-33, physicsLibrary.calculateForce(5.5, -6), .1d);
    assertEquals(-85.25, physicsLibrary.calculateForce(-15.5, 5.5), .1d);

  }

  @Test
  public void shouldFindForceOfTwoNegativeDoubles() {

    assertEquals(200, physicsLibrary.calculateForce(-10.0, -20.0), .1d);
    assertEquals(33, physicsLibrary.calculateForce(-5.5, -6), .1d);
    assertEquals(85.25, physicsLibrary.calculateForce(-15.5, -5.5), .1d);
  }

  @Test
  public void shouldFindVelocityWithPositiveDoubles() {
    assertEquals(1.666666666666667, physicsLibrary.calculateVelocity(10.1, 20.1, 3.1, 9.1), .1);
    assertEquals(5.0, physicsLibrary.calculateVelocity(20.1, 40.1, 6.1, 10.1), .1);
    assertEquals(2.9999999999999996, physicsLibrary.calculateVelocity(30.1, 60.1, 10.1, 20.1), .1);

  }

  @Test
  public void shouldFindVelocityWithNegativeDoubles() {
    assertEquals(1.666666666666667, physicsLibrary.calculateVelocity(-10.1, -20.1, -3.1, -9.1), .1);
    assertEquals(-3.71604938271605, physicsLibrary.calculateVelocity(20.1, -40.1, -6.1, 10.1), .1);
    assertEquals(-2.9999999999999996, physicsLibrary.calculateVelocity(-30.1, -60.1, 10.1, 20.1), .1);

  }

  @Test
  public void shouldFindMassTwoPositiveDoubles() {
    assertEquals(4, physicsLibrary.calculateMass(20.1, 5.1), .1d);
    assertEquals(6, physicsLibrary.calculateMass(30.1, 5.1), .1d);
    assertEquals(7.862745098039216, physicsLibrary.calculateMass(40.1, 5.1), .1d);
  }

  @Test
  public void shouldFindMassTwoNegativeDoubles() {
    assertEquals(4, physicsLibrary.calculateMass(-20.1, -5.1), .1d);
    assertEquals(6, physicsLibrary.calculateMass(-30.1, -5.1), .1d);
    assertEquals(7.862745098039216, physicsLibrary.calculateMass(-40.1, -5.1), .1d);
  }

  @Test
  public void shouldFindMassOneNegativeOnePositiveDoubles() {
    assertEquals(4, physicsLibrary.calculateMass(-20.1, -5.1), .1d);
    assertEquals(6, physicsLibrary.calculateMass(-30.1, -5.1), .1d);
    assertEquals(7.862745098039216, physicsLibrary.calculateMass(-40.1, -5.1), .1d);
  }

  @Test
  public void shouldFindAccelerationWithPositiveDoubles() {
    assertEquals(2.0, physicsLibrary.calculateAcceleration(20.1, 40.1, 40.1, 30.1), .1);
    assertEquals(2.0, physicsLibrary.calculateAcceleration(70.1, 30.1, 10.1, 30.1), .1);
    assertEquals(2.4999999999999996, physicsLibrary.calculateAcceleration(80.1, 30.1, 10.1, 30.1), .1);
  }

  @Test
  public void shouldFindAccelerationWithNegativeDoubles() {
    assertEquals(2.0, physicsLibrary.calculateAcceleration(-20.1, -40.1, -40.1, -30.1), .1);
    assertEquals(2.0, physicsLibrary.calculateAcceleration(-70.1, -30.1, -10.1, -30.1), .1);
    assertEquals(-1.2437810945273629, physicsLibrary.calculateAcceleration(-80.1, -30.1, -10.1, 30.1), .1);
  }
  @Test
  public void shouldFindDistanceTwoPositiveDoubles(){
   assertEquals (20.5,physicsLibrary.calculateDistance(4.1,5),.1d);
    assertEquals (25.5,physicsLibrary.calculateDistance(5.1,5),.1d);
    assertEquals (30.5,physicsLibrary.calculateDistance(6.1,5),.1d);
  }
  @Test
  public void shouldFindDistanceTwoNegativeDoubles(){
    assertEquals (20.5,physicsLibrary.calculateDistance(-4.1,-5),.1d);
    assertEquals (25.5,physicsLibrary.calculateDistance(-5.1,-5),.1d);
    assertEquals (30.5,physicsLibrary.calculateDistance(-6.1,-5),.1d);
  }
}