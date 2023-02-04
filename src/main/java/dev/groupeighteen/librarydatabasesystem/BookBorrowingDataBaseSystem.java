package dev.groupeighteen.librarydatabasesystem;

import dev.groupeighteen.librarydatabasesystem.model.DatabaseConnection;

public class BookBorrowingDataBaseSystem {
    private static final String haxxorPath =
        "sql/lillabiblioteket/create_lillabiblioteket.sql";

    public static void main(String[] args) {
        //DatabaseConnection.connectToDataBase("jdbc:mysql://localhost:3306/lillabiblioteket",
          //      "root", "password");

        //Connect
        DatabaseConnection.connectToMySQLServer();

        //Trying to create the database while still using the same "script"
        //DatabaseConnection.executeSQLFile(DatabaseConnection.getConnection(), haxxorPath);

        setupDatabase();
        DatabaseConnection.closeConnectionToDatabase();
        exit(0);
    }

    public static void setupDatabase() {
        //Delete DB if already exists
        DatabaseConnection.executeSingleSQLCommand("drop database if exists lillabiblioteket;");
        //Create DB
        DatabaseConnection.executeSingleSQLCommand("create database lillabiblioteket;");
        //Show DBs
        DatabaseConnection.executeQuery("SHOW DATABASES;");
        //Use DB
        DatabaseConnection.executeSingleSQLCommand("use lillabiblioteket");
        //Create tables
        DatabaseConnection.executeSqlCommandsFromFile("sql/lillabiblioteket/create_tables.sql");
        //Fill with test data
        //TODO testdata
        //Fill tables with test data
        DatabaseConnection.executeQuery("SHOW TABLES");
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