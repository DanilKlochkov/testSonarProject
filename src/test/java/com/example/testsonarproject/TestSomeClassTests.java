package com.example.testsonarproject;

import com.example.testsonarproject.service.SomeClass;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestSomeClassTests {
    
    @Test
    public void plusTest() {
        assertEquals(2, SomeClass.plus(1,1).intValue());
    }

    @Test
    public void minusTest() {
        assertEquals(2, SomeClass.minus(3,1).intValue());
    }

    @Test
    public void multiplyTest() {
        assertEquals(2, SomeClass.multiply(2,1).intValue());
    }

    @Test
    public void divideTest() {
        assertEquals(2, SomeClass.divide(4,2).intValue());
    }

    @Test
    public void divideTestWithError() {
        assertNull(ArithmeticException.class, () -> SomeClass.divide(1,0));
    }
}
