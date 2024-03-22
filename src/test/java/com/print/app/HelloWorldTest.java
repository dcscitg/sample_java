package com.print.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple HelloWorld.
 */
public class HelloWorldTest
{
    @Test
    public void testHelloWorldConstructor() {
        HelloWorld hello1 = new HelloWorld();
        HelloWorld hello2 = new HelloWorld();
        assertEquals(hello1.getMessage(), hello2.getMessage());
    }

    @Test
    public void testHelloWorldMessage()
    {
        HelloWorld hello = new HelloWorld();
        assertEquals("Hello Worlds!", hello.getMessage());
    }
}
