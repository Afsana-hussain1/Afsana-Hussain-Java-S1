package com.company;

public class IceCreamPOS {
    private String iceCreamColor;
    private String IceCreamSize;
    private boolean hasIceCreamExpired;
    private double priceOfIceCream;

    public IceCreamPOS(String iceCreamColor, String iceCreamSize, boolean hasIceCreamExpired, double priceOfIceCream) {
        this.iceCreamColor = iceCreamColor;
        IceCreamSize = iceCreamSize;
        this.hasIceCreamExpired = hasIceCreamExpired;
        this.priceOfIceCream = priceOfIceCream;
    }

    public String getIceCreamColor() {
        return iceCreamColor;
    }

    public void setIceCreamColor(String iceCreamColor) {
        this.iceCreamColor = iceCreamColor;
    }

    public String getIceCreamSize() {
        return IceCreamSize;
    }

    public void setIceCreamSize(String iceCreamSize) {
        IceCreamSize = iceCreamSize;
    }

    public boolean isHasIceCreamExpired() {
        return hasIceCreamExpired;
    }

    public void setHasIceCreamExpired(boolean hasIceCreamExpired) {
        this.hasIceCreamExpired = hasIceCreamExpired;
    }

    public double getPriceOfIceCream() {
        return priceOfIceCream;
    }

    public void setPriceOfIceCream(double priceOfIceCream) {
        this.priceOfIceCream = priceOfIceCream;
    }
}
