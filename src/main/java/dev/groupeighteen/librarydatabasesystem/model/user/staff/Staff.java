package dev.groupeighteen.librarydatabasesystem.model.user.staff;

import dev.groupeighteen.librarydatabasesystem.model.user.User;

import java.time.LocalDateTime;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/15/2023
 */
public class Staff extends User {
    protected final LocalDateTime dateHired;

    /**
     * Constructor for Staff. Creates a new Staff with userName uName, password pWord, and sets dateHired to the current
     * date and time.
     * @param uName userName for the Staff.
     * @param pWord password for the Staff.
     */
    public Staff(String uName, String pWord) {
        super(uName, pWord);
        this.dateHired = LocalDateTime.now();
    }

    /*********************************** Getters and Setters are self-explanatory. ************************************/

    public LocalDateTime getDateHired() {
        return dateHired;
    }
}
