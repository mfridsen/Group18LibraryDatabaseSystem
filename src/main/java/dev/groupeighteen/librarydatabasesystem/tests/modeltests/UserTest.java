package dev.groupeighteen.librarydatabasesystem.tests.modeltests;

import dev.groupeighteen.librarydatabasesystem.model.user.Researcher;
import dev.groupeighteen.librarydatabasesystem.model.user.Student;
import dev.groupeighteen.librarydatabasesystem.model.user.Teacher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2/13/2023
 */
public class UserTest {
    private static final String fileHandlerTest = """
               
               --------------------
               Testing User Classes   \s
               --------------------   \s
            """;

    static {
        System.out.println("\n" + fileHandlerTest);
    }

    @Test
    public void testCreateUser() {
        Student studentObj = new Student(1, "student1", "password");
        Teacher teacherObj = new Teacher(2, "teacher1", "otherpassword");
        Researcher researcherObj = new Researcher(3, "researcher1", "coolpassword");

        System.out.println("Student userID, should be 1: " + studentObj.getUserID());
        assertEquals(1, studentObj.getUserID());
        System.out.println("Student username, should be 'student1': " + studentObj.getUserName());
        assertEquals("student1", studentObj.getUserName());
        System.out.println("Student password: " + studentObj.getPassword());
        System.out.println("Student Max Items Allowed to Rent: " + studentObj.getMaxItems());
        assertEquals(5, studentObj.getMaxItems());
        System.out.println("Student Number of Currently Rented Items: " + studentObj.getNumRentedItems() + "\n");

        System.out.println("Teacher userID: " + teacherObj.getUserID());
        System.out.println("Teacher username: " + teacherObj.getUserName());
        System.out.println("Teacher password: " + teacherObj.getPassword());
        System.out.println("Teacher Max Items Allowed to Rent: " + teacherObj.getMaxItems());
        System.out.println("Teacher Number of Currently Rented Items: " + teacherObj.getNumRentedItems() + "\n");

        System.out.println("Researcher userID: " + researcherObj.getUserID());
        System.out.println("Researcher username: " + researcherObj.getUserName());
        System.out.println("Researcher password: " + researcherObj.getPassword());
        System.out.println("Researcher Max Items Allowed to Rent: " + researcherObj.getMaxItems());
        System.out.println("Researcher Number of Currently Rented Items: " + researcherObj.getNumRentedItems() + "\n");

        System.out.println("Attempting to change Currently Rented Items to 3...");
        System.out.println("Number of Currently Rented Items: " + studentObj.getNumRentedItems());
    }
}
