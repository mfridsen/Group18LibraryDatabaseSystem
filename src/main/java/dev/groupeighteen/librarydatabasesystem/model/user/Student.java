package dev.groupeighteen.librarydatabasesystem.model.user;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public class Student extends Patron {
    public Student(int userID, String userName, String password) {
        super(userID, userName, password, 5);
    }
}
