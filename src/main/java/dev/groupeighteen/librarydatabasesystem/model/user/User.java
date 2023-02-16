package dev.groupeighteen.librarydatabasesystem.model.user;

import java.util.Date;

/**
 * @author Mattias Fridsén, Johan Lund
 * @project Group18LibraryDatabaseSystem
 * @date 2023-02-02
 */
public abstract class User {
    protected static int nextUserID = 0; //SQL likes to begin at 1. First User will have ID of 0 + 1 = 1

    protected final int userID;
    protected String userName;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String phoneNum;
    protected String eMail;
    protected Date dateCreated;

    /**
     * User constructor. Creates a new User with userName uName and password pWord.
     * Calls nextUserID() to assign an auto-incremented userID to the User.
     * @param uName the userName of the User.
     * @param pWord the password of the User.
     */
    public User(String uName, String pWord) {
        this.userID = nextUserID(); //AUTO_INCREMENT in SQL
        this.userName = uName;
        this.password = pWord;
    }

    /**
     * Increments and returns the class variable nextUserID.
     * @return the new, incremented userID.
     */
    protected static int nextUserID() {
        nextUserID++; //SQL likes to begin at 1
        return nextUserID;
    }

    /**
     * Returns the current value of nextUserID.
     * @return value of nextUserID.
     */
    public static int getNextUserID() {
        return nextUserID;
    }

    /*********************************** Getters and Setters are self-explanatory. ************************************/


    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
