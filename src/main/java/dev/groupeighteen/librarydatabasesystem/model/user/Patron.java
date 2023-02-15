package dev.groupeighteen.librarydatabasesystem.model.user;

import java.util.ArrayList;

import dev.groupeighteen.librarydatabasesystem.model.item.Item;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public abstract class Patron extends User {
    protected final int maxItems;
    protected ArrayList<Item> rentedItems;
    protected float currentFine;

    /**
     * Patron constructor. Creates a Patron with userName, password and sets maxItems to a final value.
     * @param userName the username for the Patron.
     * @param password the password for the Patron.
     * @param maxItems the maximum number of items allowed for the Patron to rent.
     */
    public Patron(String userName, String password, int maxItems) {
        super(userName, password);
        this.maxItems = maxItems;
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
        if (rentedItems.size() < maxItems) {
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
        return maxItems;
    }

    public ArrayList<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(ArrayList<Item> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public float getCurrentFine() {
        return currentFine;
    }

    public void setCurrentFine(float currentFine) {
        this.currentFine = currentFine;
    }
}