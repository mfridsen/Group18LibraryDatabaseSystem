package dev.groupeighteen.librarydatabasesystem.application.view;

import java.util.Scanner;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/2/2023
 */
public class OutputHandler {

    /**
     * This method prints the given `textToPrint` to the console and prompts the user with the given `prompt`.
     * It then waits for user input and parses the input into a `String[] args` which is returned by the method.
     *
     * @param textToPrint the text to be printed to the console
     * @param prompt the prompt to be given to the user
     * @return the user input parsed into a `String[] args`
     */
    public static String[] printAndGet(String textToPrint, String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(textToPrint);
        System.out.print(prompt + ": ");
        String input = sc.nextLine();
        String[] args = input.split(" ");
        return args;
    }
}
