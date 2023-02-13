package dev.groupeighteen.librarydatabasesystem.model.user;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public abstract class Patron extends User {
    protected final int maxItems;
    protected int itemsRented;

    public Patron(int userID, String userName, String password, int maxItems) {
        super(userID, userName, password);
        this.maxItems = maxItems;
        this.itemsRented = 0;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public int getItemsRented() {
        return itemsRented;
    }

    public void setItemsRented(int itemsRented) {
        this.itemsRented = itemsRented;
    }
}
