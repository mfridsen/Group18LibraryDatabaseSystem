package dev.groupeighteen.librarydatabasesystem.application.model.user.patron;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public class Teacher extends Patron {
    public Teacher(String userName, String password) {
        super(userName, password, 10);
    }
}
