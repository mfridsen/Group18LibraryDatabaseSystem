package dev.groupeighteen.librarydatabasesystem.model.checkout;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/16/2023
 */
public class Reservation {
    private static int nextReservationID = 0; //SQL likes to begin at 1. First Checkout will have ID of 0 + 1 = 1

    private final int reservationID;
    private final int patronID;
    private final int itemID;

    public Reservation(int patronID, int itemID) {
        this.reservationID = nextCheckoutID(); //AUTO_INCREMENT in SQL
        this.patronID = patronID;
        this.itemID = itemID;
    }

    /**
     * Increments and returns the class variable nextCheckoutID.
     * @return the new, incremented checkoutID.
     */
    private static int nextCheckoutID() {
        nextReservationID++; //SQL likes to begin at 1
        return nextReservationID;
    }

    /**
     * Returns the current value of nextCheckoutID.
     * @return value of nextCheckoutID.
     */
    public static int getNextCheckoutID() {
        return nextReservationID;
    }

    /*********************************** Getters and Setters are self-explanatory. ************************************/

    public int getReservationID() {
        return reservationID;
    }

    public int getPatronID() {
        return patronID;
    }

    public int getItemID() {
        return itemID;
    }
}