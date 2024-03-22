package com.print;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class HelloWorldTest
{
    @Test
    public void testAppConstructor() {
        HelloWorldTest app1 = new HelloWorldTest();
        HelloWorldTest app2 = new HelloWorldTest();
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    @Test
    public void testAppMessage()
    {
        HelloWorldTest app = new HelloWorldTest();
        assertEquals("Hello worlds!", app.getMessage());
    }
}
