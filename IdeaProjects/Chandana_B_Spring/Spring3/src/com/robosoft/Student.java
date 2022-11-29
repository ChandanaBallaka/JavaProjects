package com.robosoft;

public class Student {
    private String stdName;

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }
    public void display(){
        System.out.println("Student name is " + stdName);
    }



}
