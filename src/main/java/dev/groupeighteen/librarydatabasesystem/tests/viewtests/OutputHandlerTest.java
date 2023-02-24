package dev.groupeighteen.librarydatabasesystem.tests.viewtests;

import dev.groupeighteen.librarydatabasesystem.application.view.OutputHandler;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/3/2023
 */
public class OutputHandlerTest {
    private static final String outputHandlerTest = """
            ---------------------------
                Output Handler Test    \s
            ---------------------------\s
            """;

    static {
        System.out.println(outputHandlerTest);
    }

    private final InputStream systemIn = System.in;

    /**
     * This test class checks the functionality of the printAndGet method. It sets the input stream with a test input
     * and calls the printAndGet method. The result is then compared with the expected output.
     */
    @Test
    public void testPrintAndGet() {
        String textToPrint = "This is the text to print";
        String prompt = "Enter your response";
        String input = "response1 response2";

        //This line of code creates an InputStream from a byte array representation of a string.
        //The ByteArrayInputStream class is a subclass of the InputStream class and it provides a way to read bytes
        //from an in-memory byte array as if it were an input stream.
        //The input.getBytes() method is used to get the byte array representation of the input string.
        //So this line of code creates a new ByteArrayInputStream object with the byte array representation of the
        //input string. This allows the contents of the input string to be read as if it were an input stream.
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        String[] expected = {"response1", "response2"};
        String[] result = OutputHandler.printAndGet(textToPrint, prompt);
        assertArrayEquals(expected, result);
        System.setIn(systemIn);
    }
}