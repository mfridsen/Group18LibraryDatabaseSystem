package dev.groupeighteen.librarydatabasesystem.model.checkout;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/15/2023
 */
public class Checkout {
    private static int nextCheckoutID = 0; //SQL likes to begin at 1. First Checkout will have ID of 0 + 1 = 1
    public static final int DVD_RETURN_TIME = 14;

    private final int checkoutID;
    private final int patronID;
    private final int itemID;
    private final int staffID;
    private final LocalDate checkoutDate;
    private final LocalDate returnDate;
    private float fine;
    private short status;

    /**
     * Checkout constructor. Creates a new Checkout with patronID pID, itemID iID and staffID sID.
     * Calls nextCheckoutID() to assign an auto-incremented checkoutID to the Checkout.
     * Sets checkoutDate to the current LocalDateTime.
     * Sets returnDate to checkoutDate + the allowed time to rent a certain Item type.
     * Sets fine to 0 and status to Checked Out.
     * @param pID patronID of the Patron.
     * @param iID itemID of the Item.
     * @param sID staffID of the Staff who created the Checkout.
     */
    public Checkout(int pID, int iID, int sID) {
        this.checkoutID = nextCheckoutID(); //AUTO_INCREMENT in SQL
        this.patronID = pID;
        this.itemID = iID;
        this.staffID = sID;
        this.checkoutDate = LocalDate.now();
        //TODO returnDate needs to depend on the item type
        this.returnDate = checkoutDate.plusDays(DVD_RETURN_TIME);
        //TODO check this
        this.fine = 0;
        //TODO change statuses, probably to ENUMS
        this.status = 1;
    }

    public Checkout(Reservation res, int sID) {
        this(res.getPatronID(), res.getItemID(), sID);
    }

    /**
     * Increments and returns the class variable nextCheckoutID.
     * @return the new, incremented checkoutID.
     */
    private static int nextCheckoutID() {
        nextCheckoutID++; //SQL likes to begin at 1
        return nextCheckoutID;
    }

    /**
     * Returns the current value of nextCheckoutID.
     * @return value of nextCheckoutID.
     */
    public static int getNextCheckoutID() {
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

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getReturnDate() {
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
