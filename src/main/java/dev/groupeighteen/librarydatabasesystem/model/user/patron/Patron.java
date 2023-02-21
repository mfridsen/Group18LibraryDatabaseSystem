package dev.groupeighteen.librarydatabasesystem.model.user.patron;

import java.util.ArrayList;

import dev.groupeighteen.librarydatabasesystem.model.item.Item;
import dev.groupeighteen.librarydatabasesystem.model.user.User;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public abstract class Patron extends User {
    protected final int MAX_ITEMS;
    protected ArrayList<Item> rentedItems;
    protected float currentFine;

    /**
     * Patron constructor. Creates a Patron with userName uName, password pWord and sets maxItems to mItems.
     * @param uName the username for the Patron.
     * @param pWord the password for the Patron.
     * @param mItems the maximum number of items allowed for the Patron to rent.
     */
    public Patron(String uName, String pWord, int mItems) {
        super(uName, pWord);
        this.MAX_ITEMS = mItems;
        this.rentedItems = new ArrayList<Item>();
        this.currentFine = 0;
    }

    /**
     * Method that returns then amount of Items rented by a Patron.
     * @return the number of Items rented.
     */
    public int getNumRentedItems() {
        return rentedItems.size();
    }

    /**
     * Method that adds a rented Item to a Patron's list of rented Items.
     * @param item the rentable Item to add.
     * @return true if the Patron hasn't yet reached their limit for rented Items, otherwise false.
     */
    public boolean addRentedItem(Item item) {
        if (rentedItems.size() < MAX_ITEMS) {
            rentedItems.add(item);
            return true;
        }
        return false;
    }

    /**
     * Method that removes a rented Item from a Patron's list of rented Items.
     * @param item the Item to remove.
     * @return true if the Patron was renting the specific Item, otherwise false.
     */
    public boolean removeRentedItem(Item item) {
        if (rentedItems.contains(item)) {
            rentedItems.remove(item);
            return true;
        }
        return false;
    }

    /**
     * Increments the fine by increment amount.
     * @param increment the amount the fine is increased by.
     */
    public void incrementFine(float increment) {
        currentFine += increment;
    }

    /*********************************** Getters and Setters are self-explanatory. ************************************/

    public int getMaxItems() {
        return MAX_ITEMS;
    }

    public ArrayList<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(ArrayList<Item> items) {
        this.rentedItems = items;
    }

    public float getCurrentFine() {
        return currentFine;
    }

    public void setCurrentFine(float fine) {
        this.currentFine = fine;
    }
}