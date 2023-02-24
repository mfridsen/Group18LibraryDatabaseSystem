package dev.groupeighteen.librarydatabasesystem.application.model.user;

import java.util.ArrayList;

/**
 * @author Mattias Fridsén
 * @project Group18LibraryDatabaseSystem
 * @date 2/15/2023
 * This class handles the Users in the database and contains methods that "should" be available in User as
 * class (static) methods, but can't be. For example, if a userName is known, one should be able to find the
 * corresponding userID of that User.
 */
public class UserHandler {
    private static ArrayList<User> users;

    /**
     * Returns the number of Users handled by the UserHandler.
     * @return the size of users.
     */
    public static int getNumUsers() {
        return users.size();
    }

    /**
     * Sets the Users for the UserHandler to handle.
     * @param users the list of Users.
     */
    public static void setUsers(ArrayList<User> users) {
        UserHandler.users = users;
    }

    /**
     * Method which, if user does not exist in users, adds user to users.
     * @param user the User to add.
     * @return true if user didn't already exist in users, otherwise false.
     */
    public static boolean addUser(User user) {
        //Can't add an object that already exists in the list
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    /**
     * Methods which removes user from users, if user exists in users.
     * @param user the User to remove.
     * @return true if user existed in users, otherwise false.
     */
    public static boolean removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            return true;
        }
        //Can't remove an object that doesn't exist in the list
        return false;
    }

    /**
     * If a User exists in user with userName, returns the userID of that User.
     * @param uName the userName of the User.
     * @return the userID of uName if uName exists in users, otherwise 0 (since userIDs start at 1).
     */
    public static int getUserID(String uName) {
        for (User user : users) {
            if (user.getUserName().equals(uName)) {
                return user.getUserID();
            }
        }
        //User with userName uName doesn't exist in users
        return 0;
    }

    /**
     * If a User exists in user with userID uID, returns the userName of that User.
     * @param uID the userID of the User.
     * @return the userName of uID if uID exists in users, otherwise null.
     */
    public static String getUserName(int uID) {
        if (uID <= 0) {
            System.out.println("ERROR: UserHandler.getUserName: uID given is <= 0");
            return null; //uIDs start at 1 and increment
        }
        for (User user : users) {
            if (user.getUserID() == uID) {
                return user.getUserName();
            }
        }
        //User with userID uID doesn't exist in users
        return null;
    }


    /**
     * Returns the password for User with userID uID, if such a User exists in users.
     * @param uID the userID of the User.
     * @return the password if the User is found, otherwise null.
     */
    public static String getPassword(int uID) {
        if (uID <= 0) {
            System.out.println("ERROR: UserHandler.getPassword: uID given is <= 0");
            return null; //uIDs start at 1 and increment
        }
        for (User user : users) {
            if (user.getUserID() == uID) {
                return user.getPassword();
            }
        }
        //User with userID uID doesn't exist in users
        return null;
    }

    /**
     * Returns the password for User with userName uName, if such a User exists in users.
     * @param uName the userName of the User.
     * @return the password if the User is found, otherwise null.
     */
    public static String getPassword(String uName) {
        for (User user : users) {
            if (user.getUserName().equals(uName)) {
                return user.getPassword();
            }
        }
        //User with userName uName doesn't exist in users
        return null;
    }
}