package dev.groupeighteen.librarydatabasesystem.model.user;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public class Researcher extends Patron {
    public Researcher(String userName, String password) {
        super(userName, password, 20);
    }

}
