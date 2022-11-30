package com.example.testsonarproject;

import com.example.testsonarproject.service.SomeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSomeClassTests {
    
    @Test
    void plusTest() {
        assertEquals(2, SomeClass.plus(1,1).intValue());
    }

    @Test
    void minusTest() {
        assertEquals(2, SomeClass.minus(3,1).intValue());
    }

    @Test
    void multiplyTest() {
        assertEquals(2, SomeClass.multiply(2,1).intValue());
    }

    @Test
    void divideTest() {
        assertEquals(2, SomeClass.divide(4,2).intValue());
    }

    @Test
    void divideTestWithError() {
        assertThrows(ArithmeticException.class, () -> SomeClass.divide(1,0));
    }
}
