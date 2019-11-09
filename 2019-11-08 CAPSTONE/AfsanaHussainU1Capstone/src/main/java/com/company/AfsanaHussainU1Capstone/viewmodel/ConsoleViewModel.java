package com.company.AfsanaHussainU1Capstone.viewmodel;

import com.company.AfsanaHussainU1Capstone.models.Consoles;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {
    private int consoleId;
    @NotNull
    @Size(max = 50, message = "Must enter a value for model")
    private String model;
    @NotNull
    @Size(max = 50, message = "Must enter a value for manufacturer")
    private String manufacturer;
    private String memoryAmount;
    private String proccessor;
    @NotNull(message = "enter a decimal value")
    private BigDecimal price;
    @NotNull(message = "enter a quantity")
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
        ConsoleViewModel viewModel = (ConsoleViewModel) o;
        return getConsoleId() == viewModel.getConsoleId() &&
                getQuantity() == viewModel.getQuantity() &&
                Objects.equals(getModel(), viewModel.getModel()) &&
                Objects.equals(getManufacturer(), viewModel.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), viewModel.getMemoryAmount()) &&
                Objects.equals(getProccessor(), viewModel.getProccessor()) &&
                Objects.equals(getPrice(), viewModel.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProccessor(), getPrice(), getQuantity());
    }
}
