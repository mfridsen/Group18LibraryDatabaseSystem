package dev.groupeighteen.librarydatabasesystem.application.view;

import dev.groupeighteen.librarydatabasesystem.application.view.screens.PrimaryHomeScreen;
import dev.groupeighteen.librarydatabasesystem.application.view.screens.HomeScreen;

import javax.swing.*;

/**
 * @author Mattias Fridsén,
 * Johan Lund,
 * Henrik Ravnborg,
 * Elmer Tallgren,
 * Jesper Truedsson
 * @project Group18LibraryDatabaseSystem
 * @date 2/23/2023
 */
public class MainView extends JFrame {
    private HomeScreen currentScreen;

    public MainView() {
        currentScreen = new PrimaryHomeScreen();

        this.add(currentScreen);
    }




    public HomeScreen getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(HomeScreen currentScreen) {
        this.currentScreen = currentScreen;
    }
}
