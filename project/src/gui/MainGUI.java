package gui;
import data.CsvLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainGUI extends JFrame {
    JTabbedPane tp = new JTabbedPane();
    CurrentForecasts currentForecastsPanel = new CurrentForecasts();
    JPanel furtherForecastsPanel = new FurtherForecasts();
    MenuOptions menuOptions = new MenuOptions(this);

    CsvLoader dataSource;

    public MainGUI(){
        tp.addTab("Current forecast", null, currentForecastsPanel);
        tp.addTab("Upcoming forecasts", null, furtherForecastsPanel);
        add(tp, BorderLayout.CENTER);
        add(menuOptions, BorderLayout.SOUTH);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            dataSource = new CsvLoader();
        } catch(IOException e) {
            JOptionPane.showConfirmDialog(this, "Failed to get data, try again?\nError: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateDataSource() throws IOException {
        dataSource.update();
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
