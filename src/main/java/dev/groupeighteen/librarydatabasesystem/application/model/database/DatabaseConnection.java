package dev.groupeighteen.librarydatabasesystem.application.model.database;

import dev.groupeighteen.librarydatabasesystem.application.BookBorrowingDataBaseSystem;

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
     * Getters and setters are self-explanatory.
     */
    public static Connection getConnection() {
        return connection;
    }
}