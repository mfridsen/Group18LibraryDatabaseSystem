package dev.groupeighteen.librarydatabasesystem.tests.modeltests;

import dev.groupeighteen.librarydatabasesystem.application.model.checkout.Checkout;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/15/2023
 */
public class CheckoutTest {

    private static final String checkoutTest = """
               
               ----------------------
               Testing Checkout Class\s
               ----------------------\s
            """;

    static {
        System.out.println("\n" + checkoutTest);
    }
    @Test
    public void testCreateCheckout(){
        LocalDate today = LocalDate.now();
        LocalDate expectedReturnDate = today.plusDays(Checkout.DVD_RETURN_TIME);
        Checkout c = new Checkout(2, 3, 4);
        System.out.println("Checking checkoutID, should be 1: " + c.getCheckoutID());
        assertEquals(1, c.getCheckoutID());
        System.out.println("Checking patronID, should be 2: " + c.getPatronID());
        assertEquals(2, c.getPatronID());
        System.out.println("Checking itemID, should be 3: " + c.getItemID());
        assertEquals(3, c.getItemID());
        System.out.println("Checking staffID, should be 4: " + c.getStaffID());
        assertEquals(4, c.getStaffID());
        System.out.println("Checking checkoutDate, should be " + today + ": " + c.getCheckoutDate());
        assertEquals(today, c.getCheckoutDate());
        System.out.println("Checking returnDate, should be " + expectedReturnDate + ": " + c.getReturnDate());
        assertEquals(expectedReturnDate, c.getReturnDate());
        System.out.println("Checking fine, should be 0.0: " + c.getFine());
        assertEquals(0, c.getFine(), 0);
        System.out.println("Checking status, should be 1: " + c.getStatus());
        assertEquals(1, c.getStatus());
    }

}
