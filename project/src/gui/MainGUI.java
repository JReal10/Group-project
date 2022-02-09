package gui;

import data.DataRepo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainGUI extends JFrame {
    JTabbedPane tp = new JTabbedPane();
    ChartDisplay deathsDisplayPanel;
    ChartDisplay casesDisplayPanel;
    DataRepo data;
    MenuOptions menuOptions;

    public MainGUI() {
        try {
            data = new DataRepo();
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(this, "Failed to get data, try again?\nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        menuOptions = new MenuOptions(this, data);
        casesDisplayPanel = new ChartDisplay(data, ChartDisplay.Mode.CASES);
        deathsDisplayPanel = new ChartDisplay(data, ChartDisplay.Mode.DEATHS);
        tp.addTab("Cases", null, casesDisplayPanel);
        tp.addTab("Deaths", null, deathsDisplayPanel);
        add(tp, BorderLayout.CENTER);
        add(menuOptions, BorderLayout.SOUTH);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainGUI();
    }

    public void refreshData() throws IOException {
        data.refresh();
    }
}
