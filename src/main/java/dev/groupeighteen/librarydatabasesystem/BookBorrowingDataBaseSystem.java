package dev.groupeighteen.librarydatabasesystem;

import dev.groupeighteen.librarydatabasesystem.model.DatabaseConnection;
import dev.groupeighteen.librarydatabasesystem.model.DatabaseHandler;

import java.sql.Connection;

public class BookBorrowingDataBaseSystem {
    private static Connection connection;

    //Makes the code prettier
    private static final String publisherTestDataPath =
            "sql/lillabiblioteket/test_data/base_tables/publisher_test_data.sql";
    private static final String userTestDataPath =
            "sql/lillabiblioteket/test_data/base_tables/user_test_data.sql";
    private static final String classificationTestDataPath =
            "sql/lillabiblioteket/test_data/base_tables/classification_test_data.sql";
    private static final String itemTestDataPath =
            "sql/lillabiblioteket/test_data/base_tables/item_test_data.sql";
    private static final String authorTestDataPath =
            "sql/lillabiblioteket/test_data/base_tables/author_test_data.sql";
    private static final String itemPublisherTestDataPath =
            "";
    private static final String itemAuthorTestDataPath =
            "sql/lillabiblioteket/test_data/join_tables/item_author_test_data.sql";
    private static final String itemCheckoutTestDataPath =
            "";
    private static final String itemClassificationTestDataPath =
            "";
    
    public static void main(String[] args) {
        //Connect
        DatabaseConnection.connectToMySQLServer();
        connection = DatabaseConnection.getConnection();

        //Setup and fill database
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
        DatabaseHandler.executeSingleSQLCommand(connection, "drop database if exists lillabiblioteket;");
        //Create DB
        DatabaseHandler.executeSingleSQLCommand(connection, "create database lillabiblioteket;");
        //Show DBs in server
        DatabaseHandler.executeQuery(connection, "SHOW DATABASES;");
        //Use DB
        DatabaseHandler.executeSingleSQLCommand(connection, "use lillabiblioteket");
        //Create tables
        DatabaseHandler.executeSqlCommandsFromFile(connection, "sql/lillabiblioteket/create_tables.sql");

        DatabaseHandler.executeQuery(connection, "SHOW TABLES");
    }

    /**
     * Fills the tables of the database with test data.
     */
    private static void fillTables() {
        //BASE TABLES
        //Publishers
        DatabaseHandler.executeSqlCommandsFromFile(connection, publisherTestDataPath);
        DatabaseHandler.printAllData(connection, "PUBLISHER");
        //Users
        DatabaseHandler.executeSqlCommandsFromFile(connection, userTestDataPath);
        DatabaseHandler.printAllData(connection, "USER");
        //Patrons
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");
        //Staffs
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");
        //Classifications
        DatabaseHandler.executeSqlCommandsFromFile(connection, classificationTestDataPath);
        DatabaseHandler.printAllData(connection, "CLASSIFICATION");
        //Items
        DatabaseHandler.executeSqlCommandsFromFile(connection, itemTestDataPath);
        DatabaseHandler.printAllData(connection, "ITEM");
        //Reservations
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");
        //Authors
        DatabaseHandler.executeSqlCommandsFromFile(connection, authorTestDataPath);
        DatabaseHandler.printAllData(connection, "AUTHOR");
        //Checkouts
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");

        //JOIN TABLES
        //Item_Publisher
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");
        //Item_Author
        DatabaseHandler.executeSqlCommandsFromFile(connection, itemAuthorTestDataPath);
        DatabaseHandler.printAllData(connection, "ITEM_AUTHOR");
        //Item_Checkout
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");
        //Item_Classification
        DatabaseHandler.executeSqlCommandsFromFile(connection, "");
        DatabaseHandler.printAllData(connection, "");
    }

    public static void exit(int status) {
        if (connection == null) { //Should always close connection to the database after use
            DatabaseConnection.closeConnectionToDatabase();
        }
        System.exit(status);
    }

    public static void exit(String errorMsg, int status) {
        if (connection == null) { //Should always close connection to the database after use
            DatabaseConnection.closeConnectionToDatabase();
        }
        System.out.println(errorMsg);
        System.exit(status);
    }
}