package com.company;

public class Radio {
    //instance variables
    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;

    //constructor

    public Radio(String manufacturerIn, String modelIn, int numSpeakerIn, String stationIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.numSpeaker = numSpeakerIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
        this.station = stationIn;

    }
    //behavioral methods

    public void togglePower() {
        System.out.println("Toggle power");

        //getters and setters
    }

    public String getManufacturer() {
        return this.manufacturer;

    }

    public String getModel() {
        return this. model;

    }

    public int getNumSpeakers() {
        return this.numSpeaker;

    }

    public String getStation() {
        return  this.station;

    }

    public int getVolume() {
        return this.volume;

    }

    public boolean isPowered() {
        return this.powered;


    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;

    }

    public void setModel(String model) {
        this.model = model;

    }

    public void setNumSpeaker(int numSpeaker) {
        this.numSpeaker = numSpeaker;
    }


    public void getStation(String station) {
        this.station = station;

    }

    public void setVolume(int volume) {
        this.volume = volume;

    }

    public void setpowered(boolean powered) {
      this.powered = powered;

    }
}