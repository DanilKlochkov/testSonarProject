package com.example.testsonarproject;

import com.example.testsonarproject.service.SomeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
class TestSonarProjectApplicationTests {

    @org.junit.Test
    public void plusTest() {
        assertEquals(2, SomeClass.plus(1,1).intValue());
    }

    @org.junit.Test
    public void minusTest() {
        assertEquals(2, SomeClass.minus(3,1).intValue());
    }

    @org.junit.Test
    public void multiplyTest() {
        assertEquals(2, SomeClass.multiply(2,1).intValue());
    }

    @org.junit.Test
    public void divideTest() {
        assertEquals(2, SomeClass.divide(4,2).intValue());
    }

    @Test(expected = ArithmeticException.class)
    public void divideTestWithError() {
        assertNull(SomeClass.divide(1,0));
    }

}
