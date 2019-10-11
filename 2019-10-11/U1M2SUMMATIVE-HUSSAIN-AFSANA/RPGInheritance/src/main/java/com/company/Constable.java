package com.company;

public class Constable extends Character{
    private String name;
    private int strength =60;
    private int health =100;
    private int stamina =60;
    private int speed =20;
    private int attackPower=5;
    public String jurisdiction;

    public void arrest(){
        System.out.println("Character arrests another character!");
    }

    @Override
    public void attack() {
        System.out.println("Character is attacking");
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
    public void heal() {
        System.out.println("Character is healed!");
    }

    @Override
    public void decreaseHealth() {
        System.out.println("Character health Decreased!");
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

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
