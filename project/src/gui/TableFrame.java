package gui;

import javax.swing.*;
import java.awt.*;

public class TableFrame extends JFrame {
    TableFrame() {
        setSize(700,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TableDisplayPanel displayPanel = new TableDisplayPanel();
        add(displayPanel);
        TableButtonPanel buttonPanel = new TableButtonPanel(this);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
