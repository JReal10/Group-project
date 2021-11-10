package gui;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    JTabbedPane tp = new JTabbedPane();
    CurrentForecasts currentForecastsPanel = new CurrentForecasts();
    JPanel furtherForecastsPanel = new FurtherForecasts();
    MenuOptions menuOptions = new MenuOptions();

    public MainGUI(){
        tp.addTab("Current forecast", null, currentForecastsPanel);
        tp.addTab("Upcoming forecasts", null, furtherForecastsPanel);
        add(tp, BorderLayout.CENTER);
        add(menuOptions, BorderLayout.SOUTH);
        setSize(600,600);
        setVisible(true);
    }
}
