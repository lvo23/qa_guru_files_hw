package com.lvo23.pojo;

/**
 * @author Vlad Litvinov
 */
public class DriverPojo {

    private String name;

    private int number;

    public DriverPojo(String name, int number) {

        this.name = name;
        this.number = number;
    }

    public DriverPojo() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {

        this.number = number;
    }

    @Override
    public String toString() {

        return "DriverPojo{" + "name='" + name + '\'' + ", number=" + number + '}';
    }
}
