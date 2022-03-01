package gui;

import data.DataRepo;
import linear_regression.Estimator;
import linear_regression.Model;
import linear_regression.OrdLeastSquares;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TableDisplayPanel extends JPanel {
    TableDisplayPanel(DataRepo data) {
        LayoutManager layout = new BorderLayout();
        setLayout(layout);
        String[] columnNames = {"Day", "Cases", "Deaths"};
        String[][] tableData = new String[7][];
        double[] dates = data.getDateOffsets();
        double[] cases = data.getCases();
        double[] deaths = data.getDeaths();
        Estimator estimator = new OrdLeastSquares();
        Model casesModel = estimator.getModel(dates, cases);
        Model deathsModel = estimator.getModel(dates, deaths);
        DecimalFormat df = new DecimalFormat("###,###");
        df.setMaximumIntegerDigits(15);
        for (int i = 0; i < 7; i++) {
            double day = dates[0] + i;
            double predictedCases = casesModel.predict(day + 1);
            double predictedDeaths = deathsModel.predict(day + 1);
            tableData[i] = new String[3];
            tableData[i][0] = "+" + Integer.toString(i + 1) + " days";
            tableData[i][1] = df.format(predictedCases);
            tableData[i][2] = df.format(predictedDeaths);
        }
        JTable table = new JTable(tableData, columnNames);
        table.setFillsViewportHeight(true);
        add(table.getTableHeader(), BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
    }
}
