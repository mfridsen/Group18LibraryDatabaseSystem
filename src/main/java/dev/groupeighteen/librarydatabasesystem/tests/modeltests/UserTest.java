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
        Student studentObj = new Student("student1", "password");
        Teacher teacherObj = new Teacher("teacher1", "otherpassword");
        Researcher researcherObj = new Researcher("researcher1", "coolpassword");

        //Student creation testing
        System.out.println("Student userID, should be 1: " + studentObj.getUserID());
        assertEquals(1, studentObj.getUserID());
        System.out.println("Student username, should be 'student1': " + studentObj.getUserName());
        assertEquals("student1", studentObj.getUserName());
        System.out.println("Student password, should be 'password': " + studentObj.getPassword());
        assertEquals("password", studentObj.getPassword());
        System.out.println("Student maxItems, should be 5: " + studentObj.getMaxItems());
        assertEquals(5, studentObj.getMaxItems());
        System.out.println("Student numRentedItems, should be 0: " + studentObj.getNumRentedItems() + "\n");
        assertEquals(0, studentObj.getNumRentedItems());

        //Teacher creation testing
        System.out.println("Teacher userID, should be 2: " + teacherObj.getUserID());
        assertEquals(2, teacherObj.getUserID());
        System.out.println("Teacher username, should be 'teacher1': " + teacherObj.getUserName());
        assertEquals("teacher1", teacherObj.getUserName());
        System.out.println("Teacher password, should be 'otherpassword': " + teacherObj.getPassword());
        assertEquals("otherpassword", teacherObj.getPassword());
        System.out.println("Teacher maxItems, should be 10: " + teacherObj.getMaxItems());
        assertEquals(10, teacherObj.getMaxItems());
        System.out.println("Teacher numRentedItems, should be 0: " + teacherObj.getNumRentedItems() + "\n");
        assertEquals(0, teacherObj.getNumRentedItems());

        //Researcher creation testing
        System.out.println("Researcher userID, should be 'researcher1': " + researcherObj.getUserID());
        assertEquals(3, researcherObj.getUserID());
        System.out.println("Researcher username, should be 'researcher1': " + researcherObj.getUserName());
        assertEquals("researcher1", researcherObj.getUserName());
        System.out.println("Researcher password, should be 'coolpassword': " + researcherObj.getPassword());
        assertEquals("coolpassword", researcherObj.getPassword());
        System.out.println("Researcher maxItems, should be 20: " + researcherObj.getMaxItems());
        assertEquals(20, researcherObj.getMaxItems());
        System.out.println("Researcher numRentedItems, should be 0: " + researcherObj.getNumRentedItems() + "\n");
        assertEquals(0, researcherObj.getNumRentedItems());


    }
}
