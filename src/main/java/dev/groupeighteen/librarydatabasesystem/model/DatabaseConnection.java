package dev.groupeighteen.librarydatabasesystem.model;

import dev.groupeighteen.librarydatabasesystem.BookBorrowingDataBaseSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/3/2023
 *
 * Here's a general outline of the steps to connect a Java application to a database:
 *
 * Load the JDBC driver: To connect to a database, you first need to load the JDBC driver specific to the database
 * you're using. For example, if you're using MySQL, you would load the MySQL DatabaseConnection/J driver.
 *
 * Establish a connection: Once you've loaded the driver, you can establish a connection to the database.
 * To do this, you'll need to provide the database URL, username, and password.
 *
 * Create a statement: After establishing a connection, you can create a statement to execute SQL commands.
 *
 * You can use the Statement interface or the PreparedStatement interface to create a statement.
 *
 * Execute SQL commands: Using the statement, you can execute various SQL commands, such as SELECT, INSERT, UPDATE,
 * and DELETE, to interact with the database.
 *
 * Close the connection: Finally, you should always close the connection to the database when you're done.
 */
public class DatabaseConnection {
    private static Connection connection = null;

    /**
     This method connects the Java application to a specific database.
     It loads the JDBC driver, and then establishes a connection to the database
     using the provided url, user, and password parameters. If there are any
     errors connecting to the database, the method will throw a
     ClassNotFoundException or SQLException.
     @param url the URL of the database to connect to
     @param user the username to use when connecting to the database
     @param password the password to use when connecting to the database
     */
    public static void connectToDataBase(String url, String user, String password) {
        try {
            // Load the JDBC driver
            System.out.println("Loading JDBC driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded JDBC driver.");

            // Establish a connection
            System.out.println("Connecting to: " + user + "@" + url);
            connection = DriverManager.getConnection(url,
                    user, password);
            System.out.println("Connected to: " + user + "@" + url);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Couldn't connect to database.", 1);
        }
    }

    /**
     * Standard connection-method for a default-configured MySQL Server. Connects to the server,
     * not a specific database.
     *
     * Connects with the following parameters:
     * user: root
     * password: password
     * server: localhost
     * port: 3306
     *
     * Loads the JDBC driver, and then establishes a connection to the database
     * using the provided url, user, and password parameters. If there are any
     * errors connecting to the database, the method will throw a
     * ClassNotFoundException or SQLException.
     */
    public static void connectToMySQLServer() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "password";

        try {
            // Load the JDBC driver
            System.out.println("Loading JDBC driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded JDBC driver.");

            // Establish a connection
            System.out.println("Connecting to: " + user + "@" + url);
            connection = DriverManager.getConnection(url,
                    user, password);
            System.out.println("Connected to: " + user + "@" + url);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Couldn't connect to database.", 1);
        }
    }

    /**
     * Closes the connection.
     */
    public static void closeConnectionToDatabase() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to execute a SQL query.
     */
    public static void executeQuery(String query) {
        try {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            System.out.println("Running query: " + query);
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and print the data
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Couldn't perform query: " + query, 1);
        }
    }

    /**
     * Executes a single SQL command.
     * Note that this method assumes that the connection variable has been properly initialized,
     * and is of type java.sql.Connection.
     * Also, this method does not check for any syntax errors in the SQL commands,
     * so it may fail with a SQLException if there are any.
     *
     * Doesn't print any results, simply executes command.
     */
    public static void executeSingleSQLCommand(String command) {
        System.out.println("Attempting to execute: " + command);
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(command);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Error executing SQL command: " + command, 1);
        }
        System.out.println("Command successful.");
    }

    /**
     * A simple method which reads the contents of a file, and executes any SQL commands it finds in that file
     * @param filePath the path of the file
     */
    public static void executeSqlCommandsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder commandBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                // Skip comments
                if (line.startsWith("--")) {
                    continue;
                }
                // Append the line to the command string, adding a space in between
                commandBuilder.append(line).append(" ");

                // Check if the line ends with a semicolon, signifying the end of the command
                if (line.endsWith(";")) {
                    String command = commandBuilder.toString();
                    executeSingleSQLCommand(command);
                    // Reset the command builder for the next command
                    commandBuilder = new StringBuilder();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Couldn't find file at path " + filePath, 1);
        } catch (IOException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Couldn't read file at path " + filePath, 1);
        }
    }

    /**
     * Getters and setters are self-explanatory.
     */
    public static Connection getConnection() {
        return connection;
    }
}