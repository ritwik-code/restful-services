package com.practice.restwebservices.restfulservices.helloworld;

public class HelloWorldBean {
    private String helloWorld;
    public HelloWorldBean(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String getHelloWorld() {
        return helloWorld;
    }
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "helloWorld='" + helloWorld + '\'' +
                '}';
    }
}
