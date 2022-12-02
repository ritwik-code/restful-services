package com.practice.restwebservices.restfulservices.helloworld;

public class PersonV2 {
    String firstName;
    String secondName;

    public PersonV2(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
