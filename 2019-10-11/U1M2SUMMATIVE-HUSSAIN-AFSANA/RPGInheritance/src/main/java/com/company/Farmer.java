package com.company;

public class Farmer extends Character {
    private String name;
    private int strength = 75;
    private int health = 100;
    private int stamina = 75;
    private int speed = 10;
    private int attackPower = 1;

    @Override
    public void run() {
        System.out.println("Character is running");
    }

    @Override
    public void harvest() {
        System.out.println("Character is harvesting");
    }

    @Override
    public void attack() {
        System.out.println("Character is attacking");
    }

    @Override
    public void heal() {
        System.out.println("Character is healed");
    }

    @Override
    public void decreaseStamina() {
        System.out.println("Stamina is decreased");
    }

    @Override
    public void increaseStamina() {

        System.out.println("Stamina is increased");
    }

    @Override
    public void plow() {
        System.out.println("Character is plowing");
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
}

