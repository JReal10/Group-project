package gui;

import javax.swing.*;

import linear_regression.Estimator;
import linear_regression.Model;
import linear_regression.OrdLeastSquares;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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
        double[] dayOffsets = app.data.getDateOffsets();
        double[] deaths = app.data.getDeaths();
        XYSeries deathsSeries = new XYSeries("Deaths");
        for(int i=0; i<dayOffsets.length; i++) deathsSeries.add(dayOffsets[i], deaths[i]);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(deathsSeries);
        Model model = refreshModel(dayOffsets, deaths);
        chart = ChartFactory.createScatterPlot("Covid-19", "Days", "Deaths", dataset, PlotOrientation.VERTICAL, false, false, false);
        if(dayOffsets.length>1) {
            double x1 = dayOffsets[0];
            double y1 = model.predict(x1);
            double x2 = dayOffsets[dayOffsets.length-1];
            double y2 = model.predict(x2);
            XYAnnotation modelLine = new XYLineAnnotation(x1,y1,x2,y2);
            XYPlot plot = chart.getXYPlot();
            plot.addAnnotation(modelLine);
        }
        chartPanel = new ChartPanel(chart);
    }

    Model refreshModel(double[] x, double[] y) {
        Estimator ols = new OrdLeastSquares();
        return ols.getModel(x,y);
    }
}
