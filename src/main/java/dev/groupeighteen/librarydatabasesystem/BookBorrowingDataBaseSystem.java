package dev.groupeighteen.librarydatabasesystem;

import dev.groupeighteen.librarydatabasesystem.model.DatabaseConnection;

public class BookBorrowingDataBaseSystem {
    private static final String haxxorPath =
        "sql/lillabiblioteket/create_lillabiblioteket.sql";

    public static void main(String[] args) throws Exception {
        DatabaseConnection.connectToDataBase("jdbc:mysql://localhost:3306/lillabiblioteket",
                "root", "password");

        //Trying to create the database while still using the same "script"
        //DatabaseConnection.executeSQLFile(DatabaseConnection.getConnection(), haxxorPath);

        DatabaseConnection.executeQuery("SHOW TABLES");
        DatabaseConnection.closeConnectionToDatabase();
        exit(0);
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