package com.example.testsonarproject.service;

import org.springframework.stereotype.Component;

@Component
public class SomeClass {

    public static Integer plus(int x, int y) {
        return x + y;
    }

    public static Integer minus(int x, int y) {
        return x - y;
    }

    public static Integer multiply(int x, int y) {
        return x * y;
    }

    public static Integer divide(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }
}
