package gui;

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CurrentForecasts extends JPanel {
    private JTextArea myTextArea;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private MainGUI app;

    public CurrentForecasts(MainGUI app){
        this.app = app;
        myTextArea = new JTextArea("Current forecast graph will go here");

        refreshChart();
        add(chartPanel);
        add(myTextArea);
    }

    void refreshChart() {
        long[] dayOffsets = app.data.getDateOffsets();
        int[] deaths = app.data.getDeaths();
        XYSeries deathsSeries = new XYSeries("Deaths");
        for(int i=0; i<dayOffsets.length; i++) deathsSeries.add(dayOffsets[i], deaths[i]);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(deathsSeries);
        chart = ChartFactory.createScatterPlot("Covid-19", "Days", "Deaths", dataset, PlotOrientation.VERTICAL, false, false, false);
        chartPanel = new ChartPanel(chart);
    }
}
