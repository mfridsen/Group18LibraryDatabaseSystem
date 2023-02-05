package dev.groupeighteen.librarydatabasesystem;

import dev.groupeighteen.librarydatabasesystem.model.DatabaseConnection;

public class BookBorrowingDataBaseSystem {
    public static void main(String[] args) {
        //Connect
        DatabaseConnection.connectToMySQLServer();

        setupDatabase();
        fillTables();

        //Should always close connection to the database after use
        DatabaseConnection.closeConnectionToDatabase();
        exit(0);
    }

    /**
     * Deletes lillabiblioteket and stars over from scratch, initializing all the tables and
     * then filling them with test data.
     */
    private static void setupDatabase() {
        //Delete DB if already exists
        DatabaseConnection.executeSingleSQLCommand("drop database if exists lillabiblioteket;");
        //Create DB
        DatabaseConnection.executeSingleSQLCommand("create database lillabiblioteket;");
        //Show DBs in server
        DatabaseConnection.executeQuery("SHOW DATABASES;");
        //Use DB
        DatabaseConnection.executeSingleSQLCommand("use lillabiblioteket");
        //Create tables
        DatabaseConnection.executeSqlCommandsFromFile("sql/lillabiblioteket/create_tables.sql");

        DatabaseConnection.executeQuery("SHOW TABLES");
    }

    /**
     * Fills the tables of the database with test data.
     */
    private static void fillTables() {
        //BASE TABLES
        //Publishers
        DatabaseConnection.executeSqlCommandsFromFile("sql/lillabiblioteket/test_data/publisher_test_data.sql");
        DatabaseConnection.printAllData("PUBLISHER");
        //Users
        DatabaseConnection.executeSqlCommandsFromFile("sql/lillabiblioteket/test_data/user_test_data.sql");
        DatabaseConnection.printAllData("USER");
        //Patrons
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Staffs
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Classifications
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Items
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Reservations
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Authors
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Checkouts
        DatabaseConnection.executeSqlCommandsFromFile("");
        //JOIN TABLES
        //Item_Publisher
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Item_Author
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Item_Checkout
        DatabaseConnection.executeSqlCommandsFromFile("");
        //Item_Classification
        DatabaseConnection.executeSqlCommandsFromFile("");
    }

    public static void exit(int status) {
        if (DatabaseConnection.getConnection() == null) { //Should always close connection to the database after use
            DatabaseConnection.closeConnectionToDatabase();
        }
        System.exit(status);
    }

    public static void exit(String errorMsg, int status) {
        if (DatabaseConnection.getConnection() == null) { //Should always close connection to the database after use
            DatabaseConnection.closeConnectionToDatabase();
        }
        System.out.println(errorMsg);
        System.exit(status);
    }
}