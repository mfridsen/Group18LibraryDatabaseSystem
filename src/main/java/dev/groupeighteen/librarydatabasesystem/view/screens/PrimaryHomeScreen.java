package dev.groupeighteen.librarydatabasesystem.view.screens;

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
public class PrimaryHomeScreen extends HomeScreen {
    private JButton loginButton;
    private JButton backButton;
    private JButton helpButton;

    //Menu Bar
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem helpMenuItem;
    private JMenuItem FAQMenuItem;
    private JMenuItem infoMenuItem;

    //Search part


    public PrimaryHomeScreen() {
        menuBar = new JMenuBar();
        helpMenu = new JMenu("help");
        helpMenuItem = new JMenuItem("help");
        FAQMenuItem = new JMenuItem("FAQ");
        infoMenuItem = new JMenuItem("info");

        //Adds menu items to menu
        helpMenu.add(helpMenuItem);
        helpMenu.add(FAQMenuItem);
        helpMenu.add(infoMenuItem);
        //Adds menu to menu bar
        menuBar.add(helpMenu);
        //Adds menu bar to this JPanel
        this.add(menuBar);
    }
}
