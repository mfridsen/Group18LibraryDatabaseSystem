package dev.groupeighteen.librarydatabasesystem.model;

import dev.groupeighteen.librarydatabasesystem.BookBorrowingDataBaseSystem;

import java.sql.*;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/3/2023
 *
 * Here's a general outline of the steps to connect a Java application to a database:
 *
 * Load the JDBC driver: To connect to a database, you first need to load the JDBC driver specific to the database
 * you're using. For example, if you're using MySQL, you would load the MySQL Connector/J driver.
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
public class Connector {

    public static void connectToDatabase() {
        Connection connection = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lillabiblioteket", "root", "password");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a SELECT statement
            ResultSet resultSet = statement.executeQuery("show tables");

            // Iterate through the result set and print the data
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Couldn't connect to database.", 1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
