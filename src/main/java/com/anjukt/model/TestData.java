package com.anjukt.model;

public class TestData {

    private String email;
    private String password;


    public TestData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public TestData() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Booking(email=" + this.getEmail() + ")";
    }

}
