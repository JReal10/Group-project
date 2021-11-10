package gui;

import javax.swing.*;

public class CurrentForecasts extends JPanel {
    private JTextArea myTextArea;

    /* An actual graph will be implemented here later */

    public CurrentForecasts(){
        myTextArea = new JTextArea("Current forecast graph will go here");
        add(myTextArea);
    }
}
