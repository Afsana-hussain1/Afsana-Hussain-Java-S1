package com.company.AfsanaHussainU1Capstone.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Consoles {
    private int consoleId;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String proccessor;
    private BigDecimal price;
    private  int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProccessor() {
        return proccessor;
    }

    public void setProccessor(String proccessor) {
        this.proccessor = proccessor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consoles consoles = (Consoles) o;
        return getConsoleId() == consoles.getConsoleId() &&
                getQuantity() == consoles.getQuantity() &&
                Objects.equals(getModel(), consoles.getModel()) &&
                Objects.equals(getManufacturer(), consoles.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), consoles.getMemoryAmount()) &&
                Objects.equals(getProccessor(), consoles.getProccessor()) &&
                Objects.equals(getPrice(), consoles.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProccessor(), getPrice(), getQuantity());
    }
}
