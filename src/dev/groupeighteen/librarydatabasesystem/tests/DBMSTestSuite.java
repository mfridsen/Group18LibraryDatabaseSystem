package dev.groupeighteen.librarydatabasesystem.tests;

import dev.groupeighteen.librarydatabasesystem.tests.viewtests.OutputHandlerTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/2/2023
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //Model tests

        //View tests
        OutputHandlerTest.class,
        //Controller tests

})

public class DBMSTestSuite {
    private static final String testSuite = """
            ---------------------------
                     TEST SUITE        \s
            ---------------------------\s
            """;

    private static final String testResult = """
            
            ---------------------------
                    TEST RESULT        \s
            ---------------------------\s
            """;

    public static void main(String[] args) {
        System.out.println(testSuite);
        Result result = JUnitCore.runClasses(DBMSTestSuite.class);
        printResults(result);
    }

    private static void printResults(Result result) {
        System.out.println(testResult);
        System.out.println("Number of tests run: " + result.getRunCount());
        System.out.println("Number of tests failed: " + result.getFailureCount());
        printFailures(result);
    }

    private static void printFailures(Result result) {
        System.out.println("Failed tests: ");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
    }
}