package gui;

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DomainOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import java.util.List;

public class CurrentForecasts extends JPanel {
    private JTextArea myTextArea;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private MainGUI app;

    public CurrentForecasts(MainGUI app){
        this.app = app;
        myTextArea = new JTextArea("Current forecast graph will go here");

        List<Integer> list = new ArrayList<Integer>();
        XYSeries deaths = new XYSeries("Deaths");
        for(int i=0; i<10; i++) deaths.add(i, i);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(deaths);
        chart = ChartFactory.createScatterPlot("Covid-19", "Days", "Deaths", dataset, PlotOrientation.HORIZONTAL, false, false, false);
        chartPanel = new ChartPanel(chart);
        add(chartPanel);
        add(myTextArea);
    }
}
