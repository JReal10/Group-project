package gui;

import data.DataRepo;

import javax.swing.*;
import java.awt.*;

public class TableFrame extends JFrame {
    TableFrame(DataRepo data) {
        setSize(700, 600);
        setVisible(true);
        setTitle("Cases");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TableDisplayPanel displayPanel = new TableDisplayPanel(data);
        add(displayPanel, BorderLayout.CENTER);
        TableButtonPanel buttonPanel = new TableButtonPanel(this);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
