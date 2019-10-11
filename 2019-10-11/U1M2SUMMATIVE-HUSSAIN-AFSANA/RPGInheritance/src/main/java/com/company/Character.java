package com.company;

public class Character {
    private String name;
    private int strength ;
    private int health ;
    private int stamina ;
    private int speed ;
    private int attackPower;

    public void run(){
        System.out.println("character is running");
    }

    public void plow(){
        System.out.println("Character is plowing");
    }
    public void harvest(){
        System.out.println("Character is harvesting");
    }
    public void attack(){
        System.out.println("Character is attacking");
    }
    public void heal(){
        System.out.println("Character is healed!");
    }
    public void decreaseHealth(){
        System.out.println("Character health Decreased!");
    }
    public  void increaseStamina(){
        System.out.println("Character stamina increased!");
    }
    public void decreaseStamina(){
        System.out.println("Character stamina decreased");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}


