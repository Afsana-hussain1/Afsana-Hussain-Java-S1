package com.company;

public class Warrior extends Character {
    private String name;
    private int strength  = 75;
    private int health  = 100;
    private int stamina = 100;
    private int speed = 50;
    private int attackPower= 10;
    private int shieldStrength  = 100;

   public void decreaseShieldStrength(){
    System.out.println("Shield strength decreased!");
}
  public void run(){
      System.out.println("Character is running");
  }

    @Override
    public void attack() {
        System.out.println("Character is attacking");
    }

    @Override
    public void heal() {
        System.out.println("Character is healed!");
    }

    @Override
    public void increaseStamina() {
        System.out.println("Character stamina increased!");
    }

    @Override
    public void decreaseStamina() {
        System.out.println("Character stamina decreased");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
