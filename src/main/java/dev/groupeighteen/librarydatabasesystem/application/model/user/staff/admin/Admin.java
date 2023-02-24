package dev.groupeighteen.librarydatabasesystem.application.model.user.staff.admin;

import dev.groupeighteen.librarydatabasesystem.application.model.user.staff.Staff;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/16/2023
 */
public class Admin extends Staff {
    public Admin(String uName, String pWord) {
        super(uName, pWord);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}