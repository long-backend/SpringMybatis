package com.example.demo.model;

public class Address {
    private int addressid;
    private String city;
    private String conscious;

    public int getAddressId() {
        return addressid;
    }

    public String getCity() {
        return city;
    }

    public void setAddressId(int addressId) {
        this.addressid = addressId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setConscious(String conscious) {
        this.conscious = conscious;
    }

    public String getConscious() {
        return conscious;
    }
}
