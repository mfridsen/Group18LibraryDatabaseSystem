package dev.groupeighteen.librarydatabasesystem.tests.modeltests;

import dev.groupeighteen.librarydatabasesystem.application.model.checkout.Reservation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Elmer Tallgren
 * @project Group18LibraryDatabaseSystem
 * @date 2023-02-24
 */
public class ReservationTest {

    private static final String reservationTest = """
               
               -------------------------
               Testing Reservation Class\s
               -------------------------\s
            """;

    static {
        System.out.println("\n" + reservationTest);
    }
    @Test
    public void testCreateReservation() {
        Reservation r = new Reservation(12,13);
        System.out.println("Checking reservationID, should be 1: " + r.getReservationID());
        assertEquals(1, r.getReservationID());

        System.out.println("Checking patronID, should be 12: " + r.getPatronID());
        assertEquals(12, r.getPatronID());

        System.out.println("Checking itemID, should be 13: " + r.getItemID());
        assertEquals(13, r.getItemID());
    }
}
