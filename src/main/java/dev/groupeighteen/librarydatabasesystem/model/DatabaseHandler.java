package dev.groupeighteen.librarydatabasesystem.model;

import dev.groupeighteen.librarydatabasesystem.BookBorrowingDataBaseSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/5/2023
 */
public class DatabaseHandler {
    /**
     * Attempts to execute a SQL query.
     */
    public static void executeQuery(Connection connection, String query) {
        try {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            System.out.println("\nRunning query: " + query);
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and print the data
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

            statement.close(); //Always close statements after use
            resultSet.close(); //Always close result sets after use
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
    public static void executeSingleSQLCommand(Connection connection, String command) {
        System.out.println("\nAttempting to execute: " + command);
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(command);
            statement.close(); //Always close statements after use
        } catch (SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("Error executing SQL command: " + command, 1);
        }
        System.out.println("Command successful.");
    }

    //TODO correct this
    /**
     * This method takes two arguments: a Statement object, which is used to execute SQL statements,
     * and a String that represents the name of the table you want to retrieve the data from.
     * The method uses the executeQuery method of the Statement object to execute the
     * SELECT * FROM <tableName> statement and retrieve the result in a ResultSet object.
     *
     * Then, it uses the ResultSetMetaData object to get information about the columns in the result set,
     * and the number of columns. The method loops through the rows in the result set using a while loop,
     * and for each row, it loops through the columns and retrieves the data using the rs.getString(i) method,
     * where i is the column index. Finally, it prints the data for each column separated by a space,
     * and goes to the next line for each row.
     */
    public static void printAllData(Connection connection, String tableName) {
        if (tableName.length() == 0) {
            System.out.println("ERROR: printAllData: No table given.");
            return;
        }

        System.out.println("\nPrinting all data found in table: " + tableName);
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }

            statement.close(); //Always close statements after use
            rs.close(); //Always close result sets after use
        } catch (SQLException e) {
            e.printStackTrace();
            BookBorrowingDataBaseSystem.exit("ERROR: printAllData: for table: " + tableName, 1);
        }
        System.out.println();
    }

    /**
     * A simple method which reads the contents of a file, and executes any SQL commands found in that file.
     * @param filePath the path of the file
     */
    public static void executeSqlCommandsFromFile(Connection connection, String filePath) {
        if (filePath.length() == 0) {
            System.out.println("ERROR: executeSqlCommandsFromFile: No filepath.");
            return;
        }

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
                    executeSingleSQLCommand(connection, command);
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


    public void CreateStaff(Connection connection, int StaffID, Date dateHired, int staffTypeID) {
        try {
            // First, create the user in the User table using the CreateUser procedure
            CallableStatement createUserStatement = connection.prepareCall("{ call CreateUser(?,?,?,?,?,?,?,?,?) }");
            createUserStatement.setInt(1, StaffID);
            createUserStatement.setString(2, "");  // User name
            createUserStatement.setString(3, "");  // Password
            createUserStatement.setString(4, "");  // First name
            createUserStatement.setString(5, "");  // Last name
            createUserStatement.setString(6, "");  // Phone number
            createUserStatement.setString(7, "");  // Email
            createUserStatement.setDate(8, (java.sql.Date) dateHired);
            createUserStatement.setString(9, "Staff");  // User type
            createUserStatement.execute();

            // Then insert the staff specific information into the Staff table
            String insertStaffSQL = "INSERT INTO Staff (Staff_ID, Date_Hired, Staff_Type_ID) VALUES (?, ?, ?)";
            PreparedStatement insertStaffStatement = connection.prepareStatement(insertStaffSQL);
            insertStaffStatement.setInt(1, StaffID);
            insertStaffStatement.setDate(2, (java.sql.Date) dateHired);
            insertStaffStatement.setInt(3, staffTypeID);
            insertStaffStatement.executeUpdate();

            createUserStatement.close();
            insertStaffStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CreatePatron(Connection connection, int PatronID, int patronTypeID, int itemsRented) throws SQLException {
        try {
            // First, create the user in the User table using the CreateUser procedure
            CallableStatement createUserStatement = connection.prepareCall("{ call CreateUser(?,?,?,?,?,?,?,?,?) }");
            createUserStatement.setInt(1, PatronID);
            createUserStatement.setString(2, "");  // User name
            createUserStatement.setString(3, "");  // Password
            createUserStatement.setString(4, "");  // First name
            createUserStatement.setString(5, "");  // Last name
            createUserStatement.setString(6, "");  // Phone number
            createUserStatement.setString(7, "");  // Email
            createUserStatement.setDate(8, (java.sql.Date) new Date());  // Current date
            createUserStatement.setString(9, "Patron");  // User type
            createUserStatement.execute();

            // Then insert the patron specific information into the Patron table
            String insertPatronSQL = "INSERT INTO Patron (Patron_ID, Patron_Type_ID, Items_Rented) VALUES (?, ?, ?)";
            PreparedStatement insertPatronStatement = connection.prepareStatement(insertPatronSQL);
            insertPatronStatement.setInt(1, PatronID);
            insertPatronStatement.setInt(2, patronTypeID);
            insertPatronStatement.setInt(3, itemsRented);
            insertPatronStatement.execute();

            createUserStatement.close();
            insertPatronStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}