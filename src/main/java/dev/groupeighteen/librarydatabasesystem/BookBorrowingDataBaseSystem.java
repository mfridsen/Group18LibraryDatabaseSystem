package dev.groupeighteen.librarydatabasesystem;

import dev.groupeighteen.librarydatabasesystem.model.Connector;

public class BookBorrowingDataBaseSystem {

    public static void main(String[] args) {
        Connector.connectToDatabase();
        exit(0);
    }

    public static void exit(int status) {
        System.exit(status);
    }

    public static void exit(String errorMsg, int status) {
        System.out.println(errorMsg);
        System.exit(status);
    }
}
