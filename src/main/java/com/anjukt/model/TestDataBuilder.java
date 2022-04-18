package com.anjukt.model;

public class TestDataBuilder {
    private String email;
    private String password;

    public TestDataBuilder email(String email) {
        this.email = email;
        return this;
    }

    public TestDataBuilder password(String password) {
        this.password = password;
        return this;
    }

    public TestData build() {
        return new TestData(email, password);
    }
}