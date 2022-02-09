package gui;

import data.DataRepo;
import linear_regression.Model;
import linear_regression.PiecewiseEstimator;
import linear_regression.PiecewiseModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class ChartDisplay extends JPanel {
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private DataRepo data;
    private String ylabel;
    private Mode mode;
    private PiecewiseModel model;

    public ChartDisplay(DataRepo data, Mode mode) {
        this.data = data;
        this.mode = mode;
        switch (mode) {
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
        double[] dayOffsets = data.getDateOffsets();
        double[] yvalues = mode == Mode.CASES ? data.getCases() : data.getDeaths();
        XYSeries yseries = new XYSeries(ylabel);
        for (int i = 0; i < dayOffsets.length; i++) yseries.add(dayOffsets[i], yvalues[i]);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(yseries);
        model = refreshModel(dayOffsets, yvalues);
        XYSeries extrapolationSeries = new XYSeries(ylabel);
        for (int i = dayOffsets.length; i < dayOffsets.length + 31; i++) {
            extrapolationSeries.add(i, model.predict(i));
        }
        dataset.addSeries(extrapolationSeries);
        chart = ChartFactory.createScatterPlot("Covid-19", "Days since First Case", ylabel, dataset, PlotOrientation.VERTICAL, false, false, false);
        if (dayOffsets.length > 1) {
            XYPlot plot = chart.getXYPlot();
            double first = 0;
            for (double bound : model.getBounds()) {
                double x1 = first;
                double x2 = bound;
                double y1 = model.predict(x1);
                double y2 = model.predict(x2);
                XYAnnotation modelLine = new XYLineAnnotation(x1, y1, x2, y2);
                plot.addAnnotation(modelLine);
                first = bound;
            }
            double x1 = first;
            double x2 = dayOffsets[dayOffsets.length - 1];
            double y1 = model.predict(x1);
            double y2 = model.predict(x2);
            XYAnnotation modelLine = new XYLineAnnotation(x1, y1, x2, y2);
            plot.addAnnotation(modelLine);
        }
        chartPanel = new ChartPanel(chart);
    }

    PiecewiseModel refreshModel(double[] x, double[] y) {
        PiecewiseEstimator estimator = new PiecewiseEstimator();
        return (PiecewiseModel) estimator.getModel(x, y);
    }

    public Model getModel() {
        return model;
    }

    enum Mode {
        DEATHS,
        CASES
    }
}
