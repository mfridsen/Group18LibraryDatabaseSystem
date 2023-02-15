package dev.groupeighteen.librarydatabasesystem.model.checkout;

import java.time.LocalDateTime;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/15/2023
 */
public class Checkout {
    private static int nextCheckoutID = 0; //SQL likes to begin at 1. First Checkout will have ID of 0 + 1 = 1

    protected final int checkoutID;
    protected final int patronID;
    protected final int itemID;
    protected final int staffID;
    protected final LocalDateTime checkoutDate;
    protected final LocalDateTime returnDate;
    protected float fine;
    protected short status;

    public Checkout(int patronID, int itemID, int staffID) {
        this.checkoutID = getNextCheckoutID(); //AUTO_INCREMENT in SQL
        this.patronID = patronID;
        this.itemID = itemID;
        this.staffID = staffID;
        this.checkoutDate = LocalDateTime.now();
        this.returnDate = checkoutDate.plusDays(14);
        this.fine = 0;
        this.status = 1;
    }

    private static int getNextCheckoutID() {
        nextCheckoutID++; //SQL likes to begin at 1
        return nextCheckoutID;
    }

    /*********************************** Getters and Setters are self-explanatory. ************************************/

    public int getCheckoutID() {
        return checkoutID;
    }

    public int getPatronID() {
        return patronID;
    }

    public int getItemID() {
        return itemID;
    }

    public int getStaffID() {
        return staffID;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
