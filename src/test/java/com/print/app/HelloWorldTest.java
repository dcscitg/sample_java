package com.print.app;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testMainMethod() {
        // Redirect standard output to a buffer
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method of HelloWorld
        HelloWorld.main(new String[]{});

        // Get the output from the buffer
        String output = outputStream.toString().trim();

        // Assert that the output contains "Hello worlds!"
        assertTrue(output.contains("Hello worlds!"));

        // Reset standard output
        System.setOut(System.out);
    }
}
