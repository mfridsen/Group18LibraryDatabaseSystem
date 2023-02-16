package dev.groupeighteen.librarydatabasesystem.model.user;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public class Student extends Patron {
    public Student(String userName, String password) {
        super(userName, password, 5);
    }
}
