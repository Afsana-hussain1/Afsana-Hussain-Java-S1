package com.company;

public class Customer {
    private String firstName;
    private String lastNmae;
    private String email;
    private int phoneNumber;
    private  String ShippingAddress;
    private String street1;
    private String street2;
    private String state;
    private String billingAddress;

    public Customer(String firstName, String lastNmae, String email, int phoneNumber, String shippingAddress, String street1, String street2, String state, String billingAddress) {
        this.firstName = firstName;
        this.lastNmae = lastNmae;
        this.email = email;
        this.phoneNumber = phoneNumber;
        ShippingAddress = shippingAddress;
        this.street1 = street1;
        this.street2 = street2;
        this.state = state;
        this.billingAddress = billingAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
