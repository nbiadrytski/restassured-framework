package com.nikolay.constructors;

public class VipPerson {
    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipPerson() {  // calls constructor with 3 params
        this("Default name", 5000.0, "default@def.com");
    }

    public VipPerson(String name, double creditLimit) {  // calls constructor with 3 params
        this(name, creditLimit, "unknown@email.com");
    }

    public VipPerson(String name, double creditLimit, String emailAddress) { //saves values to fields
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}


