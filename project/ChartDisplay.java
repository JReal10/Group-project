package gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import linear_regression.Estimator;
import linear_regression.Model;
import linear_regression.OrdLeastSquares;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChartDisplay extends JPanel {
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private MainGUI app;
    private String ylabel;
    private Mode mode;

    public ChartDisplay(MainGUI app, Mode mode){
        this.app = app;
        this.mode = mode;
        switch(mode) {
            case CASES:
                ylabel = "Cases";
                break;
            case DEATHS:
                ylabel = "Deaths";
                break;
            default:
                assert false; // unreachable
        }

        refreshChart();
        add(chartPanel);
    }

    void refreshChart() {
        double[] dayOffsets = app.data.getDateOffsets();
        double[] yvalues = mode==Mode.CASES ? app.data.getCases() : app.data.getDeaths();
        XYSeries yseries = new XYSeries(ylabel);

        for(int i=0; i<dayOffsets.length; i++) yseries.add(dayOffsets[i], yvalues[i]);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(yseries);
        Model model = refreshModel(dayOffsets, yvalues);
        chart = ChartFactory.createScatterPlot("Covid-19", "Days since First Case", ylabel, dataset, PlotOrientation.VERTICAL, false, false, false);
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
        myFunction(chart);

    }
    void myFunction(JFreeChart chart){
        try{
            BufferedImage ylabel = chart.createBufferedImage(700,500);
            File outputfile = new File ("./output.png");
            ImageIO.write(ylabel, "png", outputfile);
        }

        catch (IOException e) {
            System.out.println("ERROR, could not create file. ");
        }
    }


    Model refreshModel(double[] x, double[] y) {
        Estimator ols = new OrdLeastSquares();
        return ols.getModel(x,y);
    }

    enum Mode {
        DEATHS,
        CASES
    }
}
