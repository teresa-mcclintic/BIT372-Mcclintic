package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterUnitTest {

    Converter c = new Converter();
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void pound_conversion_isCorrect() {
        assertEquals(c.toKilogram(10), 4.54, 0.1);
    }
    @Test
    public void fahrenheit_conversion_isCorrect() {
        assertEquals(c.toCelcius(32), 0.0, 0.1);
    }
    @Test
    public void inches_conversion_isCorrect() {
        assertEquals(c.toCentimeters(10), 25.4, 0.1);
    }
    @Test
    public void quarts_conversion_isCorrect() {
        assertEquals(c.toLiters(10), 9.46, 0.1);
    }
}