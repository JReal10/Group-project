package gui;

import javax.swing.*;

public class FurtherForecasts extends JPanel {
    private JTextArea myTextArea;

    /* An actual graph will be implemented here later */

    public FurtherForecasts(){
        myTextArea = new JTextArea("Next weeks forecast graph will go here");
        add(myTextArea);
    }
}
