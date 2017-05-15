package com.pondthaitay.mvp.tweentyscoops.manager;

public class Calculator {

    private static Calculator instance;

    public static Calculator getInstance() {
        if (instance == null)
            instance = new Calculator();
        return instance;
    }

    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }
}