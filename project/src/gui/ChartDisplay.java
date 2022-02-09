package gui;

import data.DataRepo;
import linear_regression.Estimator;
import linear_regression.Model;
import linear_regression.OrdLeastSquares;
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
    private Model model;

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
        chart = ChartFactory.createScatterPlot("Covid-19", "Days since First Case", ylabel, dataset, PlotOrientation.VERTICAL, false, false, false);
        if (dayOffsets.length > 1) {
            double x1 = dayOffsets[0];
            double y1 = model.predict(x1);
            double x2 = dayOffsets[dayOffsets.length - 1];
            double y2 = model.predict(x2);
            XYAnnotation modelLine = new XYLineAnnotation(x1, y1, x2, y2);
            XYPlot plot = chart.getXYPlot();
            plot.addAnnotation(modelLine);
        }
        chartPanel = new ChartPanel(chart);
    }

    Model refreshModel(double[] x, double[] y) {
        Estimator ols = new OrdLeastSquares();
        return ols.getModel(x, y);
    }

    public Model getModel() {
        return model;
    }

    enum Mode {
        DEATHS,
        CASES
    }
}
